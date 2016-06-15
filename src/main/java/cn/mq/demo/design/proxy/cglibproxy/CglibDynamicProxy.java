package cn.mq.demo.design.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by qiangzi on 16/6/13.
 */
public class CglibDynamicProxy implements MethodInterceptor{

    public Object getInstance(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(methodProxy.getSignature().getName());
        for(Object o:args){
            System.out.println(o);
        }
        System.out.println("方法前执行");
        long t1 = System.currentTimeMillis();
        Object result = null;
        try{
            result = methodProxy.invokeSuper(proxy, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("方法耗时:" + (System.currentTimeMillis() - t1));
        System.out.println("方法后执行");
        return result;
    }
}
