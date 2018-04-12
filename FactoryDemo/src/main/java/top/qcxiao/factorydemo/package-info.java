package top.qcxiao.factorydemo;

/**
 * 主要应用场景
 * 主要解决接口选择的问题。
 * 何时使用：需要不同条件下创建不同子类的实例时
 * 如何解决：在工厂接口中添加对产品子类的支持，返回的也是一个抽象的产品
 * 关键代码：工厂方法中根据不同条件，返回实例化的不同子类
 *
 * 优点：工厂模式可以解决接口选择问题，屏蔽细节，提供创建对象接口
 * 缺点：当有新增功能时，需要修改工厂类和实际对象
 */