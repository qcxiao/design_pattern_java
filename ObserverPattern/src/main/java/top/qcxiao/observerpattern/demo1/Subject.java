package top.qcxiao.observerpattern.demo1;

/**
 * 用于创建目标对象，提供注册和删除观察者的接口
 * @author qcxiao
 *
 */
public interface Subject {
	
	/**
	 * 注册观察者
	 * @param observer
	 */
	void attach(Observer observer);
	/**
	 * 删除观察者
	 * @param observer
	 */
	void detach(Observer observer);
	
	/**
	 * 向所有注册的观察者发送消息
	 */
	void notifyObservers();
}
