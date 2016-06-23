package cn.mq.demo.thread.executors;

import java.util.concurrent.*;

/**
 * Created by qiangzi on 16/6/21.
 */
public class PoolExecutors {

    public static void main(String[] args) {


        //30 : 核心线程数
        //100 : 最大线程数
        //60 : 空闲线程最长存活时间
        //TimeUnit.SECONDS : 单位
        //LinkedBlockingQueue 缓冲队列

        ExecutorService poolExecutor = new ThreadPoolExecutor(
                30,
                100,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(50)
        );


        ExecutorService executor = new ThreadPoolExecutor(
                3,
                6,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2)
        );

        for(int i=0;i<100;i++){
            try {
                String task = "task " + i;
                System.out.println("创建任务并提交到线程池中:" + task);
                executor.execute(new MCallable(task));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class MCallable implements Runnable {

    private String attch;

    public MCallable(String attch){
        this.attch = attch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始执行任务:" + attch);
        this.attch = null;
    }

    public String getTask(){
        return this.attch;
    }
}
