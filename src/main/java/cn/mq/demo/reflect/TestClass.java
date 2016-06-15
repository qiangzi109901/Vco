package cn.mq.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by qiangzi on 16/6/15.
 */
public class TestClass {

    public static void ps(Class<?> cls){
        System.out.println(cls.getName() + "----" + cls.getSimpleName());
    }

    public static User map2User(Map<String,Object> data){
        User user = new User();
        Field[] fields = User.class.getDeclaredFields();
        for(Field field : fields){
            String fieldName = field.getName();
            if(data.containsKey(fieldName)){
                Object val = data.get(fieldName);
                String fieldType = field.getType().getSimpleName();
                String valType = val.getClass().getSimpleName();
                if(fieldType.equals(valType)){
                    String setMethodName = "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
                    Method method = null;
                    try {
                        method = User.class.getMethod(setMethodName,field.getType());
                        method.invoke(user, val);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return user;
    }


    public static void main(String[] args) {


        Map<String,Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 20);
        data.put("workYear", 2);

        User u = map2User(data);
        System.out.println(u);








        ps(Float.class);
        ps(String.class);
        ps(Double.class);
        ps(Integer.class);
        ps(Date.class);
        ps(Map.class);
        ps(HashMap.class);
        ps(List.class);
        ps(ArrayList.class);


        Class<User> mcls = User.class;
        try {
            User user = mcls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println(TestClass.class.getName());
        System.out.println(TestClass.class.getSimpleName());
        System.out.println(String.class.getName());
        System.out.println(String.class.getSimpleName());

        try {
            Field field = User.class.getDeclaredField("age");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Field[] fields = User.class.getDeclaredFields();
        for(Field f:fields){
            Class cls = f.getType();
            System.out.println(f.getName() + ":" + cls.getName() + "-" + cls.getSimpleName());
        }

        Map<String,Object> params = new HashMap<>();
        params.put("name", "eee");

        System.out.println(params.get("eeee"));


        try {
            Method method = User.class.getMethod("setName", String.class);
            System.out.println(method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Method method = User.class.getDeclaredMethod("setName", String.class);
            System.out.println(method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }



}
