package cn.chstor.springframework;

/**
 * @author : bing
 * @date : 2024/8/5 20:15
 * @modyified By :
 * BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
 */
public class BeanDefinition {
    private Object bean;
    //
    public BeanDefinition(Object bean){
        this.bean = bean;
    }
    public Object getBean(){
        return bean;
    }
}
