package cn.mq.demo.java8.demo_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qiangzi on 16/6/22.
 */
public class CompareTest {


    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(50, "张三"));
        users.add(new User(10, "李四"));
        users.add(new User(30, "王五"));
        users.add(new User(20, "赵康"));
        users.add(new User(6, "琪琪"));
        users.add(new User(17, "孙威"));
        users.add(new User(39, "刘塞"));
    }

    public static void main(String[] args) {

        //普通模式
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        printUsers();

        Collections.shuffle(users);
        //lamdba模式
        Collections.sort(users, (User o1,User o2) -> {
            return o1.getAge() - o2.getAge();
        });
        printUsers();


        Collections.shuffle(users);
        //更精简的lamdba表达式
        Collections.sort(users, (User o1,User o2) -> o1.getAge() - o2.getAge());

        printUsers();

    }

    public static void printUsers(){
        for(User u:users){
            System.out.println(u);
        }
        System.out.println();
        System.out.println("- - - - - - 华丽的分割线 - - - - - -");
        System.out.println();
    }
}


class User {
    private int age;

    private String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}