package top.qcxiao.proxydemo.dynamicproxy.self;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 时间记录
 */
@Slf4j
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Method m, Object args) {
        log.info("开始时间:" + new Date());
        try {
            m.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("结束时间:" + new Date());
    }

    @Override
    public void invoke(Method m) {
        log.info("开始时间:" + new Date());
        try {
            m.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("结束时间:" + new Date());
    }
}
