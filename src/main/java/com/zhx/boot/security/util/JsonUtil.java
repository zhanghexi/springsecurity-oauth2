package com.zhx.boot.security.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

/**
 * @author zhx
 * @date 2018/10/10 10:08
 * @description
 */
@Log4j2
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObj2String(Object obj) {
        String s = null;
        try {
            s = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("convertObj2String转换异常：{}", e.getMessage());
        }
        return s;
    }

    public static <T> T convertString2Obj(String s, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(s, clazz);
        } catch (IOException e) {
            log.error("convertString2Obj转换异常：{}", e.getMessage());
        }
        return t;
    }
}