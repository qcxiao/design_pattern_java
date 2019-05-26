package top.qcxaio.strategypattern.handle;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import top.qcxaio.strategypattern.util.BeanTool;

import java.util.Map;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 15:25
 */
public class HandlerContext {
    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return (AbstractHandler) BeanTool.getBean(clazz);
    }
}
