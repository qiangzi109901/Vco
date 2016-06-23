package cn.mq.demo.design.singletom.easy;

/**
 * Created by qiangzi on 16/6/22.
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
