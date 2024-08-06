package cn.chstor.springframework.beans;

/**
 * @author : bing
 * @date : 2024/8/6 7:44
 * @modyified By :
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg){
        super(msg);
    }
    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }
}
