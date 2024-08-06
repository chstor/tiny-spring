package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.beans.BeansException;
import cn.chstor.springframework.beans.factory.BeanFactory;
import cn.chstor.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : bing
 * @date : 2024/8/6 8:26
 * @modyified By :抽象类定义模板方法
 */
public abstract class AbstractBeanFactory
        extends DefaultSingletonBeanRegistry implements BeanFactory {
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException;
}
