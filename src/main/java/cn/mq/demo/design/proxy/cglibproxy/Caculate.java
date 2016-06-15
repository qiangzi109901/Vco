package cn.mq.demo.design.proxy.cglibproxy;

/**
 * Created by qiangzi on 16/6/13.
 */
public class Caculate {

    private String name;

    public Caculate() {
    }

    public Caculate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long run(long total){
        long sum = 0;
        for(long i = 0;i<total;i++){
            sum += i;
        }
        return sum;
    }
}
