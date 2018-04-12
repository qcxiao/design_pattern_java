package top.qcxiao.factorydemo.basic;

public class FactoryBasic {
    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        factory.getFruit("apple").eat();
        factory.getFruit("orange").eat();
    }
}

/**
 * 抽象出一个类别
 */
abstract class Fruit {
    public abstract void eat();
}

/**
 * 具体的对象
 */
class Apple extends Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

/**
 * 具体的对象
 */
class Orange extends Fruit {
    @Override
    public void eat() {
        System.out.println("eat orange");
    }
}

/**
 * 根据不同类别提供不同对象
 */
class FruitFactory {
    public Fruit getFruit(String type) {
        if ("orange".equals(type)) {
            return new Orange();
        } else if ("apple".equals(type)) {
            return new Apple();
        } else {
            return null;
        }
    }
}