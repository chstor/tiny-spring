package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : bing
 * @date : 2024/8/6 8:27
 * @modyified By :
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
