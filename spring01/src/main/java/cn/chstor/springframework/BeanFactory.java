package cn.chstor.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : bing
 * @date : 2024/8/5 20:13
 * @modyified By :
 * BeanFactory，代表了 Bean对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
 */
public class BeanFactory {
    private Map<String,BeanDefinition> beanFactoryMap = new ConcurrentHashMap<>();
    //
    public Object getBean(String name){
        return beanFactoryMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanFactoryMap.put(name,beanDefinition);
    }
}
