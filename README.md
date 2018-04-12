# 设计模式-Java

## 工厂模式
在工厂模式中，创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。个人认为，工厂模式就是面向对象编程最基础的实现和最直接的证明
### 主要应用场景
* 主要解决接口选择的问题
* 何时使用：需要不同条件下创建不同子类的实例时
* 如何解决：在工厂接口中添加对产品子类的支持，返回的也是一个抽象的产品
* 关键代码：工厂方法中根据不同条件，返回实例化的不同子类
### 实现方式
#### 基础实现
通过条件分支实现，调用接口时主动传参指明是需要实例化哪个实现类，并且当实现对象有增、删，也需要相应修改工厂类
#### 优雅实现
通过反射实现，只需要传入完整类名，就可以实例化对应对象
### 总结：
* 优点：工厂模式可以解决接口选择问题，屏蔽细节，提供创建对象接口
* 缺点：当有新增功能时，需要修改工厂类和实际对象
## 代理模式
* 静态代理
* jdk动态代理与cglib动态代理

## 观察者模式


