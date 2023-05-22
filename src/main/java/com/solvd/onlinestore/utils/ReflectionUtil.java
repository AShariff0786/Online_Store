package com.solvd.onlinestore.utils;

import com.solvd.onlinestore.Cart;
import com.solvd.onlinestore.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtil {
    private final static Logger LOGGER = LogManager.getLogger(ReflectionUtil.class);
    public static Object createObject(String className, DataUtil data){
        Class classOrder;
        Object o;
        try {
            classOrder = Class.forName(className);
            o = classOrder.getConstructor().newInstance();
            List<Field> fields = Arrays.stream(classOrder.getDeclaredFields()).collect(Collectors.toList());
            fields.stream().forEach(field ->{
                if(data.getData().containsKey(field.getName())){
                    try {
                        Field declearedField = classOrder.getDeclaredField(field.getName());
                        declearedField.setAccessible(true);
                        declearedField.set(o,data.getData().get(declearedField.getName()));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        LOGGER.error("Unable to get or access the specified field.");
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            LOGGER.error("Unable to find the requested class or methods.");
            throw new RuntimeException(e);
        }
        return o;
    }

}
