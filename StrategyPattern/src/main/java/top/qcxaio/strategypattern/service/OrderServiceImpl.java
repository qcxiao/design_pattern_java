package top.qcxaio.strategypattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qcxaio.strategypattern.entity.Order;
import top.qcxaio.strategypattern.handle.AbstractHandler;
import top.qcxaio.strategypattern.handle.HandlerContext;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 15:17
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private HandlerContext context;
    @Override
    public String handle(Order order) {
        AbstractHandler handler = context.getInstance(order.getType());
        return handler.handle(order);
    }
}
