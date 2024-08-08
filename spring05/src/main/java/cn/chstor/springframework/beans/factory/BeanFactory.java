package cn.chstor.springframework.beans.factory;

import cn.chstor.springframework.beans.BeansException;

/**
 * @author : bing
 * @date : 2024/8/6 19:40
 * @modyified By :
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    Object getBean(String name,Object... args) throws BeansException;

}
