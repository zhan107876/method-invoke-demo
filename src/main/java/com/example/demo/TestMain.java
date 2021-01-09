package com.example.demo;

import com.example.demo.tan.TestBean;
import com.example.demo.tan.TestT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.ReflectUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Test
 *
 * @Author XZ.Tan
 * @Date: 2021/1/9 10:03
 * @Version 1.0
 */
@Slf4j
public class TestMain {
    public static void main(String[] args) {

        // 创建对象
        TestT<TestBean> testT = new TestT();
        TestBean testBean = new TestBean();
        testBean.setName("zhan");
        testBean.setCode("hhaa");
        List<Object> paramList = new ArrayList<>();

        // 测试获取
        String deleteHql = testT.createDeleteHql(testBean, paramList);

        // 打印结果
        log.info("deleteHql=" + deleteHql);
        paramList.forEach(v->{
            log.info("param = " + v);
        });
    }
}