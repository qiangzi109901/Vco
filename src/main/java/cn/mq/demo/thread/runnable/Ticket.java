package cn.mq.demo.thread.runnable;

/**
 * Created by qiangzi on 16/6/17.
 */
public class Ticket {


    public static void main(String[] args) {


        Runnable r1 = new TicketRunnable();
        new Thread(r1,"A").start();
        new Thread(r1,"B").start();

        System.out.println("***************************");

        Runnable r2 = new TicketRunnable2();
        new Thread(r2,"C").start();
        new Thread(r2,"D").start();

        System.out.println("***************************");

        Runnable r3 = new TicketRunnable3(100);
        new Thread(r3,"E").start();
        new Thread(r3,"F").start();
        new Thread(r3,"G").start();

        System.out.println("***************************");

        Runnable r4 = new TicketRunnable4(10);
        new Thread(r4,"H").start();
        new Thread(r4,"I").start();
        new Thread(r4,"J").start();

        System.out.println("***************************");

        Runnable r5 = new TicketRunnable5(10);
        new Thread(r5,"L").start();
        new Thread(r5,"M").start();
        new Thread(r5,"N").start();

    }
}

class TicketRunnable implements Runnable {

    private int tickets = 10;

    @Override
    public void run() {
        while(this.tickets > 0){
            System.out.println("线程" + Thread.currentThread().getName() + "卖票了:");
            this.tickets = tickets - 1;
            System.out.println("剩余:" + tickets + "张票");
        }
    }
}



class TicketRunnable2 implements Runnable {

    private int tickets = 10;

    @Override
    public void run() {
        synchronized (this){
            while(this.tickets > 0){
                System.out.println("线程" + Thread.currentThread().getName() + "卖票了:");
                this.tickets = tickets - 1;
                System.out.println("剩余:" + tickets + "张票");
            }
        }
    }
}



class TicketRunnable3 implements Runnable {

    private int tickets = 10;

    public TicketRunnable3(){

    }

    public TicketRunnable3(int tickets){
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while(this.tickets > 0){
            System.out.println("线程" + Thread.currentThread().getName() + "卖票了:");
            synchronized (this){
                if(this.tickets == 0){
                    System.out.println("没票了");
                }
                else{
                    this.tickets = tickets - 1;
                    System.out.println("剩余:" + tickets + "张票");
                }
            }
        }

    }
}



class TicketRunnable4 implements Runnable {

    private int tickets = 10;

    public TicketRunnable4(){

    }

    public TicketRunnable4(int tickets){
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while(this.tickets > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "卖票了:");
            synchronized (this){
                if(this.tickets == 0){
                    System.out.println("没票了");
                }
                else{
                    this.tickets = tickets - 1;
                    System.out.println(Thread.currentThread().getName() + "卖票成功,剩余:" + tickets + "张票");
                }
            }
        }
    }
}



class TicketRunnable5 implements Runnable {

    private int tickets = 10;
    private int total = 0;

    public TicketRunnable5(){

    }

    public TicketRunnable5(int tickets){
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while(this.tickets > 0){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "卖票了:");
            synchronized (this){
                if(this.tickets == 0){
                    System.out.println("没票了");
                }
                else{
                    this.tickets = tickets - 1;
                    total = total + 1;
                    System.out.println(Thread.currentThread().getName() + "卖票成功,剩余:" + tickets + "张票,卖票数:" + total);
                }
            }
        }
    }
}
