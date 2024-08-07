package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : bing
 * @date : 2024/8/6 22:42
 * @modyified By :
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
