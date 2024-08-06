package cn.chstor.springframework.beans.factory.config;

/**
 * @author : bing
 * @date : 2024/8/6 8:26
 * @modyified By :单例注册接口定义和实现
 */
public interface SingletonBeanRegistry {
    //获取单例对象
    Object getSingleton(String beanName);
}
