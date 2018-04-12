package top.qcxiao.observerpattern.demo2;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 用于创建具体的目标对象
 * 
 * @author qcxiao
 *
 */
public class BlogConcreteSubject implements top.qcxiao.observerpattern.demo2.BlogSubject {
	// 目标对象发布的消息
	private String blogContent;

	public String getBlogContent() {
		return blogContent;
	}
	
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
		this.notifyObservers();
	}

	// 存入所有的观察者
	private Vector<Observer> observers = new Vector<Observer>();

	// 把订阅了blog的人添加到访问者列表中
	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		Enumeration<Observer> enuma = observers.elements();
		// 遍历所有观察者，并通过观察者的update方法向其发送消息
		while (enuma.hasMoreElements()) {
			enuma.nextElement().update(this);
		}
	}
}
