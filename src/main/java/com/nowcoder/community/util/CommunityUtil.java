package com.nowcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    // MD5加密，md5算法对密码进行加密
    // hello -> abc123def456
    // hello + 随机字符串 -> abc123def456cdszds(提高安全性)
    public static String md5(String key){
        if(StringUtils.isBlank(key)){   // 判断key是否为空
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    // 得到一个json字符串
    public static String getJSONString(int code, String msg, Map<String, Object> map){
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if(map != null){
            for(String key:map.keySet()){   // 按key遍历map集合
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString (int code, String msg){  // 重载（同名不同参）
        return getJSONString(code, msg, null);
    }

    public static String getJSONString (int code){
        return getJSONString(code, null, null);
    }   // 重载

    public static void main(String[] args) {
        Map<String , Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",25);
        System.out.println(getJSONString(0,"ok",map));
    }
}
