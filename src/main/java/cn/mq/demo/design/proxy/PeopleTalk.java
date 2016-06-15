package cn.mq.demo.design.proxy;

/**
 * Created by qiangzi on 16/6/13.
 */
public class PeopleTalk implements ITalk{

    private String name;

    public PeopleTalk(String name){
        this.name = name;
    }

    @Override
    public void talk(String msg){
        System.out.println(msg + ",Hello ,this is " + this.name);
    }

}
