package cn.mq.demo.java8.demo_lambda;

/**
 * Created by qiangzi on 16/6/22.
 */
public class RunableTest {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":普通执行");
            }
        }).start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":lambda执行");
        }).start();

    }

}


