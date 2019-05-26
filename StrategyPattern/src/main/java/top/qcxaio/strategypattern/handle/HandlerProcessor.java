package top.qcxaio.strategypattern.handle;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import top.qcxaio.strategypattern.util.ClassScanner;

import java.util.Map;

/**
 * @Author: yaodao
 * @Date: 2019/5/24 15:46
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {
    private static final String HANDLER_PACKAGE = "top.qcxaio.strategypattern.handle.biz";

    /**
     * 扫描@HandlerType，初始化HandlerContext，将其注册到Spring容器
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScanner.scan(HANDLER_PACKAGE, HandleType.class).forEach(clazz -> {
            // 获取注解中的类型值
            String type = clazz.getAnnotation(HandleType.class).value();
            // 将注解中的类型值作为key，对应的类型作为value，保存在Map中
            handlerMap.put(type, clazz);
        });
        HandlerContext context = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }
}
