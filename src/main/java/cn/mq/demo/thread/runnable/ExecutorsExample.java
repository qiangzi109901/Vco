package cn.mq.demo.thread.runnable;

import java.util.concurrent.Executors;

/**
 * Created by qiangzi on 16/6/20.
 */
public class ExecutorsExample {

    public static void main(String[] args) {

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello single thread by executors");
            }
        });
    }
}
