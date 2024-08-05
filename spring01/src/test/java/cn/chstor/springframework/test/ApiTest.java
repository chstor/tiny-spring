package cn.chstor.springframework.test;

import cn.chstor.springframework.BeanDefinition;
import cn.chstor.springframework.BeanFactory;
import cn.chstor.springframework.test.Bean.UserService;
import org.junit.Test;

/**
 * @author : bing
 * @date : 2024/8/5 20:26
 * @modyified By :
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        //创建工厂
        BeanFactory beanFactory = new BeanFactory();
        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
