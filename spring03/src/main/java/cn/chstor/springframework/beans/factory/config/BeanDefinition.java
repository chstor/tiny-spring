package cn.chstor.springframework.beans.factory.config;

/**
 * @author : bing
 * @date : 2024/8/6 19:43
 * @modyified By :
 */
public class BeanDefinition {
    private Class beanClass;
    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
