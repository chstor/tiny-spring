package cn.chstor.springframework.test;

import cn.chstor.springframework.beans.PropertyValue;
import cn.chstor.springframework.beans.PropertyValues;
import cn.chstor.springframework.beans.factory.config.BeanDefinition;
import cn.chstor.springframework.beans.factory.config.BeanReference;
import cn.chstor.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.chstor.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.chstor.springframework.core.io.DefaultResourceLoader;
import cn.chstor.springframework.core.io.Resource;
import cn.chstor.springframework.test.bean.UserDao;
import cn.chstor.springframework.test.bean.UserService;
import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;

/**
 * @author : bing
 * @date : 2024/8/6 22:47
 * @modyified By :
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream is = resource.getInputStream();
        String content = IoUtil.readUtf8(is);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream is = resource.getInputStream();
        String content = IoUtil.readUtf8(is);
        System.out.println(content);
    }

    @Test
    public void test_xml() throws IOException{
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取配置文件&注册Bean
        reader.loadBeanDefinitions("classpath:spring.xml");
        //获取bean对象
        UserService userService = (UserService)beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }


    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注入UserDao
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        //注入UserService，添加属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        beanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class,propertyValues));

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }
    @Test
    public void test_constructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("chstor");
        System.out.println(userService);
    }
    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("chstor");
        System.out.println(userService);
    }
    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"chstor"});
        System.out.println(obj);
    }

}
