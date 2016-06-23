package cn.mq.demo.thread.concurrent.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiangzi on 16/6/22.
 */
public class MapFinal {

    private final Map<String, Integer> map;

    public MapFinal(){
        map = new HashMap<>();
        map.put("java", 1);
        map.put("go", 2);
        map.put("nodejs", 3);
        map.put("python", 4);
    }

    public boolean isStorage(String key){
        return map.containsKey(key);
    }

    public void put(String key,Integer value){
        map.put(key, value);
    }

//    public void newMap(){
//        map = new HashMap<>();   //错误
//        map.put("java", 1);
//        map.put("go", 2);
//        map.put("nodejs", 3);
//        map.put("python", 4);
//    }

    public static void main(String[] args) {
        MapFinal mapFinal = new MapFinal();
        System.out.println(mapFinal.isStorage("java"));
        System.out.println(mapFinal.isStorage("php"));
        mapFinal.put("php", 5);
        System.out.println(mapFinal.isStorage("php"));
        //final 定义变量不能被修改
    }

}
