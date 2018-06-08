package com.chris.ch1.reflecttest.t1;

import java.util.Date;

public class Person {

    private String name;
    private int    age;
    private Date   birthday;
    private String sex;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
