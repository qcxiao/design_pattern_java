package top.qcxaio.strategypattern.handle;

import java.lang.annotation.*;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 15:19
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandleType {
    String value();
}
