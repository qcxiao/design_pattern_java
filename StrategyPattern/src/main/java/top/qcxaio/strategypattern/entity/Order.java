package top.qcxaio.strategypattern.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 14:57
 */
@Data
public class Order {
    private String name;
    private BigDecimal price;

    /**
     * 订单类型：
     * 1. 普通
     * 2. 团队
     * 3. 促销
     */
    private String type;

    public static Order build() {
        return new Order();
    }

    public Order add(String filed, Object value) {
        switch (filed) {
            case "code":
                this.setName(String.valueOf(value));
                break;
            case "price":
                this.setPrice((BigDecimal) value);
                break;
            case "type":
                this.setType((String) value);
                break;
        }
        return this;
    }
}
