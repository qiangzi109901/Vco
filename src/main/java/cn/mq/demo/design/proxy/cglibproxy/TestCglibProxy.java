package cn.mq.demo.design.proxy.cglibproxy;

/**
 * Created by qiangzi on 16/6/13.
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        Caculate calulate = (Caculate)new CglibDynamicProxy().getInstance(new Caculate("Test Cglib Proxy"));
        System.out.println(calulate.getName());
        calulate.run(1);
        calulate.run(1000);
        calulate.run(10000);
        calulate.run(100000);
        calulate.run(1000000);
        calulate.run(10000000);
        calulate.run(100000000);
        calulate.run(1000000000);
        calulate.run(10000000000l);
    }
}
