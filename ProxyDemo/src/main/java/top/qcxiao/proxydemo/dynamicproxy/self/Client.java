package top.qcxiao.proxydemo.dynamicproxy.self;

public class Client {
    public static void main(String[] args) throws Exception {
        Subject subject = new RealSubject();

        //为用户管理添加事务处理
        InvocationHandler invocationHandler1 = new TransactionHandler(subject);
        subject = (Subject) Proxy.newProxyInstance(Subject.class, invocationHandler1);

        //为用户管理添加显示方法执行时间的功能
        InvocationHandler invocationHandler2 = new TimeHandler(subject);
        subject = (Subject) Proxy.newProxyInstance(Subject.class, invocationHandler2);

        // 执行目标方法
        subject.dosomething();

    }
}
