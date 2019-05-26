package top.qcxaio.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.qcxaio.strategypattern.entity.Order;
import top.qcxaio.strategypattern.service.OrderService;

import java.math.BigDecimal;

/**
 * @Author: yaodao
 * @Date: 2019/5/26 14:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@EnableAutoConfiguration
@Slf4j
public class TestOrderservice {
    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        Order order = Order.build()
                .add("name", "微信订单")
                .add("price", BigDecimal.valueOf(99.9))
                .add("type", "1");
        String result = orderService.handle(order);
        log.info(result);
    }

}
