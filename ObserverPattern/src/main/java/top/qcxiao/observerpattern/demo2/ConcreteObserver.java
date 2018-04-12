package top.qcxiao.observerpattern.demo2;

/**
 * 具体的观察者对象，实现更新方法，将状态更新到观察者对象中
 * @author qcxiao
 *
 */
public class ConcreteObserver implements Observer {
	/**
	 * 观察者名称
	 */
	private String observerName;
	/**
	 * 从目标处获取的需要更新的信息
	 */
	private String blogContent;
	/**
	 * 针对不同观察者有不同的消息提醒
	 */
	private String msg;
	
	/**
	 * 获取目标类的状态，并同步到观察者状态中
	 */
	public void update(BlogSubject blogSubject) {
		blogContent = ((BlogConcreteSubject)blogSubject).getBlogContent();
		System.out.println(observerName + "接收到消息：" + blogContent 
				+ "，PS：" + msg);
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
