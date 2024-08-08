package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.beans.BeansException;
import cn.chstor.springframework.core.io.Resource;
import cn.chstor.springframework.core.io.ResourceLoader;

/**
 * @author : bing
 * @date : 2024/8/8 8:36
 * @modyified By :
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resource) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;

}
