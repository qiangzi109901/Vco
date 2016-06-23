package cn.mq.demo.java8.demo_default;


public interface Animal {

    default void sleep(){
        eat();
        System.out.println("sleep");
    }

    void eat();


}

class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("eat bone");
    }
}

class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("eat fish");
    }
}

