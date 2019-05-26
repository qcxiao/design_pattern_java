package top.qcxaio.strategypattern.handle;

import top.qcxaio.strategypattern.entity.Order;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 15:26
 */
public abstract class AbstractHandler {
    abstract public String handle(Order order);
}
