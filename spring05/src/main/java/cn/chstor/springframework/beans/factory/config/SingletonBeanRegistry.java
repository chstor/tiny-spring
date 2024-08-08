package cn.chstor.springframework.beans.factory.config;

/**
 * @author : bing
 * @date : 2024/8/6 19:48
 * @modyified By :
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
