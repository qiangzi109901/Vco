package cn.mq.demo.thread.concurrent.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by qiangzi on 16/6/22.
 */
public class ConcurrentMapTest {

    private ConcurrentMap<String, Integer> concurrentMap;

    public ConcurrentMapTest(){
        concurrentMap = new ConcurrentHashMap<>();

    }
}
