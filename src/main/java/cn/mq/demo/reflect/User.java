package cn.mq.demo.reflect;

import java.util.Date;

public class User {
    private int age;
    private char gender;
    private String name;
    private long time;
    private float salary;
    private double money;
    private Integer workYear;
    private Date birthday;

    private Grade grade;
    private Grade grade2;

    public Grade getGrade2() {
        return grade2;
    }

    public void setGrade2(Grade grade2) {
        this.grade2 = grade2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", salary=" + salary +
                ", money=" + money +
                ", workYear=" + workYear +
                ", birthday=" + birthday +
                ", grade=" + grade +
                ", grade2=" + grade2 +
                '}';
    }
}