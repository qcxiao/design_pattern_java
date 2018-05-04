package top.qcxiao.proxydemo.dynamicproxy.self;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public void dosomething(String str) {
        log.info(str);
        log.info("RealSubject dosomething.....");
    }

    @Override
    public void dosomething() {
        log.info("无参RealSubject dosomething.....");
    }
}
