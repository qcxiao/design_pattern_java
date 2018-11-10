package top.qcxiao.proxydemo.dynamicproxy.jdk;
/**
 * jdk动态代理：
 * 1. 与静态代理一样，需要目标类实现一个目标接口
 * 2. 代理类实现Invocation接口，并覆盖invoke方法，通过反射返回Method对象
 * 3. 调用类需要通过java.lang.reflect.Proxy.newProxyInstance方法生成代理实例
 *
 * https://www.cnblogs.com/zuidongfeng/p/8735241.html
 */
