package cn.mq.demo.design.proxy.staticproxy;

import cn.mq.demo.design.proxy.ITalk;

/**
 * Created by qiangzi on 16/6/13.
 */
public class ProxyTalk {

    private ITalk talk;

    public ProxyTalk(ITalk talk){
        this.talk = talk;
    }


    public void talk(String msg){
        this.before();
        talk.talk(msg);
        this.after();
    }

    public void before(){
        System.out.println("方法前执行");
    }

    public void after(){
        System.out.println("方法后执行");
    }
}
