package top.qcxiao.proxydemo.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.dosomething();
    }
}
