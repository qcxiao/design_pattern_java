package top.qcxaio.strategypattern.handle.biz;

import org.springframework.stereotype.Component;
import top.qcxaio.strategypattern.entity.Order;
import top.qcxaio.strategypattern.handle.AbstractHandler;
import top.qcxaio.strategypattern.handle.HandleType;

/**
 * @Author: yaodao
 * @Date: 2019/5/26 14:07
 */
@Component
@HandleType("2")
public class GroupHandler extends AbstractHandler {
    @Override
    public String handle(Order dto) {
        return "处理团队订单";
    }
}
