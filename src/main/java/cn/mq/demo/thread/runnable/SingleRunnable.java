package cn.mq.demo.thread.runnable;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by qiangzi on 16/6/17.
 */
public class SingleRunnable {

    public static void main(String[] args) {


        long t1 = System.currentTimeMillis();

        long total = 1000;
        long sum = 0;
        for(long i = 0;i<=total;i++){
            sum += i;
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(sum);

        System.out.println(System.currentTimeMillis() - t1);

        Runnable r = new ThreadCalculate(total);
        new Thread(r,"A").start();
//        new Thread(r,"B").start();
//        new Thread(r,"C").start();
//        new Thread(r,"D").start();
//        new Thread(r,"E").start();
//        new Thread(r,"F").start();


        Runnable r2 = new ThreadCalculate2(total);
        new Thread(r2,"k").start();
        new Thread(r2,"k2").start();
    }

}




class ThreadCalculate implements Runnable{

    private long total;
    private long sum = 0;
    private long i = 0;
    private long t1 = System.currentTimeMillis();
    private long t2;

    public ThreadCalculate(long total){
        this.total = total;
    }


    @Override
    public void run() {

        while(i <= total){
            synchronized (this){
                if(i==total){
                    t2 = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("耗时:" + (t2 - t1));
                    System.out.println("结果:" + sum);
                    i++;
                }
                else{
                    i++;
                    sum += i;
//                    System.out.println("线程" + Thread.currentThread().getName() + "执行成功");
                }

            }
        }

    }
}



class ThreadCalculate2 implements Runnable{

    private long total;
    private AtomicLong sum = new AtomicLong(0);
    private AtomicLong i = new AtomicLong(0);
    private long t1 = System.currentTimeMillis();
    private long t2;

    public ThreadCalculate2(long total){
        this.total = total;
    }


    @Override
    public void run() {

        while(i.get() <= total){
            if(i.get()==total){
                t2 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName());
                System.out.println("耗时:" + (t2 - t1));
                System.out.println("结果:" + sum);
                i.getAndAdd(1);
            }
            else{
                i.getAndAdd(1);
                sum.getAndAdd(i.get());
//                    System.out.println("线程" + Thread.currentThread().getName() + "执行成功");
            }
        }

    }
}







