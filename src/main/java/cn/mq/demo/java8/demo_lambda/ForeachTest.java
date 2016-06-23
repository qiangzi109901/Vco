package cn.mq.demo.java8.demo_lambda;

import java.util.Arrays;

/**
 * Created by qiangzi on 16/6/22.
 */
public class ForeachTest {
    public static void main(String[] args) {

        Arrays.asList(1,2,3,4,5).forEach( e -> System.out.println(e));
    }
}
