package com.example.demo.tan;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * TestT
 *
 * @Author XZ.Tan
 * @Date: 2021/1/9 10:04
 * @Version 1.0
 */
@Slf4j
public class TestT<T> {
    /**
     * 创建删除HQL
     *
     * @param item
     * @param paramList
     * @return
     */
    public String createDeleteHql(T item, List<Object> paramList) {
        StringBuffer hqlBuffer = new StringBuffer();
        hqlBuffer.append(" DELETE ");
        hqlBuffer.append(item.getClass().getSimpleName());
        hqlBuffer.append(" where 1 = 1");
        // 获取类所有声明的字段，但但不包括继承的字段
        Field[] declaredFields = item.getClass().getDeclaredFields();
        // 遍历处理每个字段
        for (Field field : declaredFields) {
            try {
                //获取字段名称
                String name = field.getName();
                // 获取java bean的标准命名字段的get set方法
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), item.getClass());
                //获得get方法
                Method method = pd.getReadMethod();
                // 反射调用获取方法值
                Object value = getObjectMethodReturnValue(item, method);
                // 业务处理：组装HQL语句
                if (StringUtils.isNotEmpty(value.toString())) {
                    hqlBuffer.append(" AND " + name + "=? ");
                    paramList.add(value);
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }

        return hqlBuffer.toString();
    }

    /**
     * 获取对象方法的返回值
     *
     * @param target
     * @param method
     * @return
     */
    public static Object getObjectMethodReturnValue(Object target, Method method) {
        if (method == null || target == null) {
            return null;
        }
        Object value = null;
        try {
            value = method.invoke(target);
        } catch (Exception e) {
            return null;
        }
        return value;
    }

}