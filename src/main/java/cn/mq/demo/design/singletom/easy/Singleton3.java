package cn.mq.demo.design.singletom.easy;

/**
 * Created by qiangzi on 16/6/22.
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3(){}

    public static Singleton3 getInstance(){
        return instance;
    }

}
