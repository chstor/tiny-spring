package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.beans.BeansException;
import cn.chstor.springframework.beans.factory.BeanFactory;
import cn.chstor.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : bing
 * @date : 2024/8/6 20:18
 * @modyified By :
 */
public abstract class AbstractBeanFactory
        extends DefaultSingletonBeanRegistry implements BeanFactory {
    public Object getBean(String name) throws BeansException{
        return doGetBean(name,null);
    }

    public Object getBean(String name,Object... args) throws BeansException{
        return doGetBean(name,args);
    }

    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }
    protected <T> T doGetBean(final String name,final Object[] args){
        Object bean = getSingleton(name);
        if(bean != null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(beanDefinition,name,args);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(BeanDefinition beanDefinition,String beanName,Object[] args) throws BeansException;
}
