package cn.chstor.springframework.beans.factory.support;

import cn.chstor.springframework.core.io.DefaultResourceLoader;
import cn.chstor.springframework.core.io.ResourceLoader;

/**
 * @author : bing
 * @date : 2024/8/8 9:43
 * @modyified By :
 */
public abstract class AbstractBeanDefinitionReader
        implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
