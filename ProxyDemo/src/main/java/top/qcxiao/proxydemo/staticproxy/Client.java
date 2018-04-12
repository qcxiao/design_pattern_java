package top.qcxiao.proxydemo.staticproxy;

/**
 * 通过代理类调用目标类方法
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.dosomething();
    }
}
