package top.qcxiao.observerpattern.demo2;

/**
 * 测试blog观察者模式
 * @author qcxiao
 *
 */
public class TestObserver {
	public static void main(String[] args) {
		// 创建目标
		BlogConcreteSubject blogSubject = new BlogConcreteSubject();
		// 创建观察者
		ConcreteObserver observerA = new ConcreteObserver();
		observerA.setObserverName("学生A");
		observerA.setMsg("希望此信息能够帮助到你的学业");
		ConcreteObserver observerB = new ConcreteObserver();
		observerB.setObserverName("职业人B");
		observerB.setMsg("希望此信息能够帮助到你的工作");
		// 注册观察者
		blogSubject.attach(observerA);
		blogSubject.attach(observerB);
		// 目标发布博客
		blogSubject.setBlogContent("thinking in java 学习笔记");
	}
}
