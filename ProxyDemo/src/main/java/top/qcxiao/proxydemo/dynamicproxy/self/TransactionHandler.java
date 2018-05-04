package top.qcxiao.proxydemo.dynamicproxy.self;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * 事务处理
 */
@Slf4j
public class TransactionHandler implements InvocationHandler {

    private Object target;

    public TransactionHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        log.info("开启事务.....");
        try {
            m.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("提交事务.....");
    }

}
