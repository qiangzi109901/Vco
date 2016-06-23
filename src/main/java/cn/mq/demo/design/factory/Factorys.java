package cn.mq.demo.design.factory;

/**
 * Created by qiangzi on 16/6/23.
 *
 *
 * 工厂设计模式: 定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到其子类。
 *
 * 优点:
 *  1.可以使代码结构清晰,有效地封装变化.
 *  2.对调用者屏蔽具体的产品类,只需要关心产品的接口就好了
 *  3.降低耦合度
 *
 * 四要素:
 *  1.工厂接口 : 提供获取产品实例的方法
 *  2.工厂实现 : 对不同的产品都有各自的实现
 *  3.产品接口 : 对产品的功能进行定义
 *  4.产品实现 : 决定了产品在客户端的具体行为
 *
 *
 * 示例:
 *  模拟工厂生产各种商品,在接口中描述了商品的功效
 *
 * 分析:
 *  从测试结果来看,我们没有用到具体的产品实现类Product1,Product2,而是通过IProduct1,IProduct2来接收工厂创建的具体产品
 */
public class Factorys {

    public static void main(String[] args) {
        IProductFactory factory = new ProductFactory();
        IProduct1 product1 = factory.getProduct1Instance("矿泉水", "治渴");
        IProduct2 product2 = factory.getProduct2Instance("药", "治病");

        product1.func();
        product2.func();

    }
}


interface IProduct1{
    void func();
}

class Product1 implements  IProduct1{
    String name;
    String func;

    public Product1() {
    }

    public Product1(String name, String func) {
        this.name = name;
        this.func = func;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void func() {
        System.out.println("产品" + name + "的功能是:" + func);
    }
}



interface IProduct2{
    void func();
}

class Product2 implements  IProduct2{
    String name;
    String func;

    public Product2() {
    }

    public Product2(String name, String func) {
        this.name = name;
        this.func = func;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void func() {
        System.out.println("产品" + name + "的功能是:" + func);
    }
}

interface IProductFactory {
    IProduct1 getProduct1Instance(String name,String func);
    IProduct2 getProduct2Instance(String name,String func);
}

class ProductFactory implements IProductFactory {

    @Override
    public IProduct1 getProduct1Instance(String name,String func) {
        return new Product1(name, func);
    }

    @Override
    public IProduct2 getProduct2Instance(String name, String func) {
        return new Product2(name, func);
    }
}



