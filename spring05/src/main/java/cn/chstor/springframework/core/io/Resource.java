package cn.chstor.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : bing
 * @date : 2024/8/7 20:10
 * @modyified By :
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
