package cn.chstor.springframework.beans.factory.config;

/**
 * @author : bing
 * @date : 2024/8/7 15:25
 * @modyified By :
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }
    public String getBeanName() {
        return beanName;
    }
}
