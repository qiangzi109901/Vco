package cn.mq.demo.design.prototype;

/**
 * Created by qiangzi on 16/6/23.
 */
public class TestClone {

    public static void main(String[] args) {
        Person p1 = new Person(1, "张三");
        Person p2 = p1;
        Person p3 = p1.clone();
        System.out.println(p1 == p2);
        System.out.println(p1 == p3);
    }
}


class Person implements Cloneable{
    private int id;
    private String name;

    @Override
    protected Person clone(){
        try {
            return (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person(int id, String name) {
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
}