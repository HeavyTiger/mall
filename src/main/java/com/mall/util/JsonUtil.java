package com.mall.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author heavytiger
 * @version 1.0
 * @description 对象序列化为json及json反序列化为对象
 * @date 2021/12/23 12:05
 */
public class JsonUtil {
    private final static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static <T> String objToJson(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T jsonToObj(String str, Class<T> clazz){
        if(str == null || "".equals(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : mapper.readValue(str, clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
