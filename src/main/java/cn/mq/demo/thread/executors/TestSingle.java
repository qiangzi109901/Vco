package cn.mq.demo.thread.executors;

import java.util.concurrent.Executors;

/**
 * Created by qiangzi on 16/6/21.
 */
public class TestSingle {


    public static void main(String[] args) {

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在运行");
            }
        });

    }
}
