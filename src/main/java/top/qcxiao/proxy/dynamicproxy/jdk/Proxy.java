package top.qcxiao.proxy.dynamicproxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class Proxy implements InvocationHandler {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Proxy before...");
        Object object = null;
        try {
            object = method.invoke(subject, args);
        } catch (Exception e) {
            log.info("Proxy error");
            throw e;
        } finally {
            log.info("Proxy after...");
        }
        return object;
    }
}
