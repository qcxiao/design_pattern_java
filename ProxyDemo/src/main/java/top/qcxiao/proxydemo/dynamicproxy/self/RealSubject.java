package top.qcxiao.proxydemo.dynamicproxy.self;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public void dosomething() {
        log.info("RealSubject dosomething。。。");
    }
}
