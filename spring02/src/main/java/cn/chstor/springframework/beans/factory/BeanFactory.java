package cn.chstor.springframework.beans.factory;

import cn.chstor.springframework.beans.BeansException;

/**
 * @author : bing
 * @date : 2024/8/6 7:45
 * @modyified By :
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
