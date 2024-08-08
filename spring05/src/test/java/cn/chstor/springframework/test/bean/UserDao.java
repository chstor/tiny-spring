package cn.chstor.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : bing
 * @date : 2024/8/7 15:49
 * @modyified By :
 */
public class UserDao {
    private static Map<String,String> hashMap = new HashMap<>();
    static {
        hashMap.put("10001", "chstor");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
