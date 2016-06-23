package cn.mq.demo.design.prototype;

import java.util.Date;

/**
 * Created by qiangzi on 16/6/23.
 */
public class TestPrototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        ConcreatePrototype cp = new ConcreatePrototype("测试01");

        ConcreatePrototype cp2 = (ConcreatePrototype)cp.clone();

        System.out.println(cp2 == cp);
        System.out.println(cp2.getName());

        User u = new User(1, "张三");
//        u.setBirth(new Date());


        User u2 = u.clone();

        System.out.println(u == u2);
        System.out.println(u);
        System.out.println(u2);

    }

}


class Prototype implements Cloneable{

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
}

class ConcreatePrototype extends Prototype{

    private String name;

    public ConcreatePrototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("原型模式实现类");
    }
}


class User implements Cloneable{
    private int id;
    private String name;
    private Date birth;

    @Override
    protected User clone(){
        User user = null;
        try {
            user = (User) super.clone();
//            user.setBirth((Date) birth.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "birth=" + birth +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
