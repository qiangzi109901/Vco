package cn.mq.demo.java8.demo_default;

/**
 * Created by qiangzi on 16/6/22.
 */
public class TestAnimal {

    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal cat = new Cat();

//        dog.eat();
//        cat.eat();

        dog.sleep();
        cat.sleep();

    }
}
