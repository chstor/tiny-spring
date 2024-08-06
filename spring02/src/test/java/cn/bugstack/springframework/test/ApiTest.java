package cn.bugstack.springframework.test;

import cn.bugstack.springframework.test.bean.UserService;
import cn.chstor.springframework.beans.factory.config.BeanDefinition;
import cn.chstor.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author : bing
 * @date : 2024/8/6 8:28
 * @modyified By :
 */
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //初始化工厂
        DefaultListableBeanFactory beanFactory
                = new DefaultListableBeanFactory();
        //注册bean
        BeanDefinition beanDefinition
                = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");

        userService.queryUserInfo();
        UserService userService_singleton
                = (UserService)beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
