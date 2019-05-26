package top.qcxiao.factorydemo.beautiful;

/**
 * 抽象出一个类别
 */
interface Fruit {
    public abstract void eat();
}

/**
 * 具体的对象
 */
class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

/**
 * 具体的对象
 */
class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat orange");
    }
}

/**
 * 根据不同类别提供不同对象
 * 利用反射优雅实现
 * 实现对象增加，不会影响到工厂对象的增加
 */
class FruitFactory {
    public Fruit getFruit(String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class cls = Class.forName(type);
        return (Fruit)cls.newInstance();
    }
}

public class FactoryBeautiful {
    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        try {
            factory.getFruit("top.qcxiao.factorydemo.beautiful.Apple").eat();
            factory.getFruit("top.qcxiao.factorydemo.beautiful.Orange").eat();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}