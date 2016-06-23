package cn.mq.demo.design.singletom.easy;

/**
 * Created by qiangzi on 16/6/22.
 */
public class Singleton5 {

    private Singleton5(){
        System.out.println("私有构造函数被调用");
    }

    private static Singleton5 instance;

    public static Singleton5 getInstance(){
        if(instance != null){
            return instance;
        }

        synchronized (Singleton5.class){
            if(instance == null){
                instance = new Singleton5();
                System.out.println("创建一个新的实例");
            }
            else{
                System.out.println("试图创建一个存在的单例,直接返回已存在的单例");
            }
            return instance;
        }
    }


    public static void main(String[] args) {
        System.out.println("1111");
        System.out.println(getInstance());
    }
}
