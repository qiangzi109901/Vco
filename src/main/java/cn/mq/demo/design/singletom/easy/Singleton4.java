package cn.mq.demo.design.singletom.easy;

/**
 * Created by qiangzi on 16/6/22.
 */
public class Singleton4 {

    private Singleton4(){
        System.out.println("私有构造函数被调用");
    }

    private static class Singleton4Manager {
        public static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return Singleton4Manager.instance;
    }

    public static void main(String[] args) {
        System.out.println("11111");
        System.out.println(getInstance());
    }
}
