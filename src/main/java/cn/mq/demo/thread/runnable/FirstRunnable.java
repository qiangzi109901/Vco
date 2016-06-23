package cn.mq.demo.thread.runnable;

/**
 * Created by qiangzi on 16/6/17.
 */
public class FirstRunnable {

    public static void main(String[] args) {

        Thread t = new Thread(new MRunnable());

        t.start();
    }

}


class MRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }
}