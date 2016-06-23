package cn.mq.demo.thread.runnable;

import cn.mq.demo.util.FileUtil;
import cn.mq.demo.util.StringUtil;

import java.io.File;

/**
 * Created by qiangzi on 16/6/17.
 */
public class ReadFile {


    public static void main(String[] args) {

        Runnable r1 = new ReadFileRunnable("的");
        new Thread(r1, "A").start();
        new Thread(r1, "B").start();
        new Thread(r1, "C").start();

    }

}

class ReadFileRunnable implements Runnable {

    private int filesize = 10;

    private String searchName;

    private int count;

    public ReadFileRunnable(String searchName){
        this.searchName = searchName;
    }

    private File getFile(int i){
        return new File("res" + File.separator + "txt" + File.separator + i + ".txt");
    }

    @Override
    public void run() {
        while(filesize > -1){
            synchronized (this){
                if(filesize == -1){
                    System.out.println("线程" + Thread.currentThread().getName() + ",任务已完毕");
                }
                else{
                    System.out.println("线程" + Thread.currentThread().getName() + "执行");
                    String content = FileUtil.readFile(getFile(filesize));
                    int c = StringUtil.count(content, searchName);
                    System.out.println("文件" + filesize + "发现数量:" + c);
                    count += c;
                    System.out.println("总发现数量:" + count);
                    filesize --;
                }

            }
        }
    }
}


