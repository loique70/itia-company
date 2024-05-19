package com.itia.sitevitrine.utils;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    public static <T> List<Object> castToObject(List<T> objectList) {
        List<Object> objList = new ArrayList<Object>();
        for (T object : objectList)
            objList.add(castToObject(object));
        return objList;
    }

    public static <T> Object castToObject(T object) {
        return (Object) object;
    }
}
