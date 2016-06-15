package cn.mq.demo.design.proxy.dynamicproxy;

import cn.mq.demo.design.proxy.ITalk;
import cn.mq.demo.design.proxy.PeopleTalk;

/**
 * Created by qiangzi on 16/6/13.
 */
public class TestProxy {

    public static void main(String[] args) {
        ITalk talk = (ITalk)new DynamicProxy().bind(new PeopleTalk("刘德华"));
        talk.talk("张华健");


        //这里还可以代理其它类的接口,但是静态代理不能实现此功能
    }
}
