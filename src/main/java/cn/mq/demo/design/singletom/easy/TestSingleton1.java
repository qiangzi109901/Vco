package cn.mq.demo.design.singletom.easy;

/**
 * Created by qiangzi on 16/6/22.
 */
public class TestSingleton1 {


    public static void main(String[] args) {

        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();

        System.out.println(s1 == s2);

    }
}
