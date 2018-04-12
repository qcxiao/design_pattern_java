package top.qcxiao.observerpattern.demo2;

/**
 * 观察者接口
 * @author qcxiao
 *
 */
public interface Observer {
	/**
	 * 通过更新方法，当目标正在发生改变时，通知对象
	 * 传入目标对象，并获取相应的目标对象的状态
	 * @param subject
	 */
	void update(BlogSubject blogSubject);
}
