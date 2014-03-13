/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.dynamicpc;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * @author clarence
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	//方法檢查(static)，第二個關卡
    public boolean matches(Method method, Class<?> cls) {
        System.out.println("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }
    
    //方法的參數檢查(dynamic)，第三個關卡
    public boolean matches(Method method, Class<?> cls, Object[] args) {
        System.out.println("Dynamic check for " + method.getName());

        int x = ((Integer) args[0]).intValue();

        return (x != 100);
    }

    //類別檢查，第一個關卡
    public ClassFilter getClassFilter() {
        return new ClassFilter() {

            public boolean matches(Class<?> cls) {
                return (cls == SampleBean.class);
            }
        };
    }
}