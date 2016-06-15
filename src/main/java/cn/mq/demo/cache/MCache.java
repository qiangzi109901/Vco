package cn.mq.demo.cache;


import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by qiangzi on 16/6/14.
 */
public class MCache {


    private LoadingCache<String,User> cache;

    public void init(){

        CacheLoader<String, User> cacheLoader = new CacheLoader<String, User>() {
            @Override
            public User load(String key) throws Exception {
                User user = loadUserInfo();
                System.out.println("缓存:" + user);
                return user;
            }

            @Override
            public ListenableFuture<User> reload(final String key,User oldUser){
                ListenableFutureTask<User> task = ListenableFutureTask.create(new Callable<User>() {
                    @Override
                    public User call() throws Exception {
                        User user = loadUserInfo();
                        System.out.println("重新加载:" + user);
                        return user;
                    }
                });

                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(task);
                return task;
            }
        };

        RemovalListener<String, User> removalListener = new RemovalListener<String, User>() {
            @Override
            public void onRemoval(RemovalNotification<String, User> notification) {
                System.out.println("remove key from cache : " + notification.getKey());
            }
        };

        cache = CacheBuilder.newBuilder().refreshAfterWrite(2, TimeUnit.MINUTES).removalListener(removalListener).build(cacheLoader);

        getUserInfo();
    }

    public User getUserInfo(){
        try {
            return cache.get("userinfo");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User loadUserInfo(){
        User user = new User();
        user.setName(new Date().getMinutes() + ":" + new Date().getSeconds());
        user.setGender(new Date().getTime() % 2 == 0 ? "男" : "女");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }


    public static void main(String[] args) {
        MCache mCache = new MCache();
        mCache.init();
        int i = 0;
        while (i< 10){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = mCache.getUserInfo();
            System.out.println("读取缓存:" + user);
            i ++;
        }


    }
}
