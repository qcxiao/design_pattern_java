package top.qcxiao.proxydemo.dynamicproxy.jdk;

public class Client {
    public static void main(String[] args) {
        Subject subject = (Subject)java.lang.reflect.Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Subject.class},
                new Proxy(new RealSubject()));
        subject.dosomething();
    }
}
