package cn.mq.demo.thread.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by qiangzi on 16/6/21.
 */
public class TestCached {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Callable<Integer>> tasks = new ArrayList<>();

        for(int i=0;i<150;i++){
            tasks.add(new Mycallable(i));
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            if(futures == null){
                System.out.println("none");
            }
            else{
                for(Future<Integer> future:futures){
                    if(!future.isCancelled() && future.isDone()){
                        System.out.println("结果:" + future.get());
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
