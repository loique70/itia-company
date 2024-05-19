package com.itia.sitevitrine.utils;

import org.springframework.core.ParameterizedTypeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestsUtils {
    public static <T> String asJsonString(final T obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJsonString(final String str, Class<T> targetClass) {
        try {
            return new ObjectMapper().readValue(str, targetClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJsonString(final String str, TypeReference<T> targetClass) {
        try {
            return new ObjectMapper().readValue(str, targetClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJsonString(final String str, ParameterizedTypeReference<T> targetClass) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructType(targetClass.getType());
            return new ObjectMapper().readValue(str, javaType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
