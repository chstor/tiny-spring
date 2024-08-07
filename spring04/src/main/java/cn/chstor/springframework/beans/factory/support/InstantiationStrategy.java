package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.beans.BeansException;
import cn.chstor.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author : bing
 * @date : 2024/8/6 21:21
 * @modyified By :
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition,
                       String beanName,
                       Constructor ctor,
                       Object[] args
    ) throws BeansException;
}
