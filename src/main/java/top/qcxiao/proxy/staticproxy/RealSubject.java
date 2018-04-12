package top.qcxiao.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 定义目标类
 * 实现目标接口
 */
@Slf4j
public class RealSubject implements Subject {
    @Override
    public void dosomething() {
        log.info("RealSubject dosomething...");
    }
}
