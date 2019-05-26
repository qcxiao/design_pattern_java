package top.qcxaio.strategypattern.service;

import top.qcxaio.strategypattern.entity.Order;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 15:16
 */
public interface OrderService {
    /**
     * 根据订单类型走不同的链路处理
     */
    String handle(Order orderDTO);
}
