package cn.mq.demo.thread.executors;

import java.util.concurrent.Callable;

/**
 * Created by qiangzi on 16/6/21.
 */
class Mycallable implements Callable<Integer> {
    private int num;
    public Mycallable(int num){
        this.num = num;
    }
    @Override
    public Integer call(){

        System.out.println(Thread.currentThread().getName() + "在等待");
        //做一些耗时的操作
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"在运行");
        return num;
    }
}
