package top.qcxiao.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 代理类
 * 实现目标接口，并在覆写方法时加上自己的处理逻辑
 * 但是核心实现还是委托给目标类
 */
@Slf4j
public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void dosomething() {
        log.info("Proxy before");
        try {
            subject.dosomething();
        } catch (Exception e) {
            log.error("Proxy error");
            throw e;
        } finally {
            log.info("Proxy after");
        }

    }
}
