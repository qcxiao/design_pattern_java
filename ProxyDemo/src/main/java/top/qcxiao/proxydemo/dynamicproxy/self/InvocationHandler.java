package top.qcxiao.proxydemo.dynamicproxy.self;

import java.lang.reflect.Method;

public interface InvocationHandler {
    public void invoke(Method m, Object args);
    public void invoke(Method m);
}