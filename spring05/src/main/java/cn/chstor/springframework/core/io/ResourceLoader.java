package cn.chstor.springframework.core.io;

/**
 * @author : bing
 * @date : 2024/8/7 21:38
 * @modyified By :
 * 定义获取资源接口，里面传递 location 地址即可。
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
