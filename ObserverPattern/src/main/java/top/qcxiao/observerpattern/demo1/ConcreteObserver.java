package top.qcxiao.observerpattern.demo1;

/**
 * 具体的观察者对象，实现更新方法，将状态更新到观察者对象中
 * @author qcxiao
 *
 */
public class ConcreteObserver implements Observer {
	
	// 观察者状态
	private byte observerState;
	
	/**
	 * 获取目标类的状态，并同步到观察者状态中
	 */
	public void update(Subject subject) {
		observerState = ((top.qcxiao.observerpattern.demo1.ConcreteSubject)subject).getSubjectState();
		System.out.println(observerState);
	}

}
