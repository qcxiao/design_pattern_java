package top.qcxiao.proxydemo.dynamicproxy.self;

import java.lang.reflect.Method;

public interface InvocationHandler {
    public void invoke(Object o, Method m);
}