package guda.red.common.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by foodoon on 2014/12/21.
 */
public class EnumUtils {

    public static final String defaultMethodName = "getNameByValue";

    public static final Map<String, Class<?>> map = new HashMap<String, Class<?>>();
    public static final Map<String, LinkedHashMap<Object, Object>> mapCache = new HashMap<String, LinkedHashMap<Object, Object>>();


    public static Object i(Object clazz, Object code) {

        if (code == null || clazz == null) {
            return null;
        }
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = toMap(clazz);
        if(objectObjectLinkedHashMap!=null){
            return objectObjectLinkedHashMap.get(code);
        }
        return null;
    }


    public static Object f(Object clazz, Object code) {
        if (code == null || clazz == null) {
            return null;
        }
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = toMap(clazz);
        if(objectObjectLinkedHashMap!=null){
            return objectObjectLinkedHashMap.get(code);
        }
        return null;
    }

    public static LinkedHashMap<Object, Object> toMap(Object clazz) {
        if (clazz == null) {
            return null;
        }
        String className = clazz.toString();
        LinkedHashMap<Object, Object> objectObjectHashMap = mapCache.get(className);
        if (objectObjectHashMap != null) {
            return objectObjectHashMap;
        }
        try {
            Class clz = Class.forName(className);
            LinkedHashMap<Object, Object> map = new LinkedHashMap<Object, Object>();
            try {
                Method getName = clz.getMethod("getName");
                Method getValue = clz.getMethod("getValue");
                Object[] objs = clz.getEnumConstants();
                for (Object obj : objs) {
                    map.put(getValue.invoke(obj), getName.invoke(obj));
                }
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(EnumUtils.i("guda.task.biz.enums.BooleanEnum", 1));
    }
}
