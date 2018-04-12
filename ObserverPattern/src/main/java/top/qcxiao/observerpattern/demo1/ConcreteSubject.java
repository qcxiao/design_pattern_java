package top.qcxiao.observerpattern.demo1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 用于创建具体的目标对象
 * 
 * @author qcxiao
 *
 */
public class ConcreteSubject implements Subject {
	// 目标对象的状态
	private byte subjectState;

	public byte getSubjectState() {
		return subjectState;
	}
	
	// 必须要先设置，再通知
	public void setSubjectState(byte subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}

	// 存入所有的观察者
	private Vector<Observer> observers = new Vector<Observer>();

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
