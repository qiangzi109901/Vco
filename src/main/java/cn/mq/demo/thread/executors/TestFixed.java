package cn.mq.demo.thread.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by qiangzi on 16/6/21.
 */
public class TestFixed {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> tasks = new ArrayList();
        for(int i=0;i<10;i++){
            tasks.add(new Mycallable(i));
        }
        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            if(futures == null || futures.isEmpty()){
                System.out.println("nothing...");
            }
            else{
                for(Future<Integer> future:futures){
                    if(!future.isCancelled() && future.isDone()){
                        int a = future.get();
                        System.out.println("结果:" + a);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


