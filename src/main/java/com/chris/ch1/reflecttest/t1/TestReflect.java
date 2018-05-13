package com.chris.ch1.reflecttest.t1;

public class TestReflect {

    public static void main(String[] args){

        Class<Person> personClazz = Person.class;
        System.out.println(personClazz.getName());
        Class<XiaoMing> xiaomingClazz = XiaoMing.class;
        System.out.println(xiaomingClazz.getName());

        Person personObj = new Person();
        XiaoMing xiaomingObj = new XiaoMing();

        Class<? extends Person> ll = xiaomingClazz.asSubclass(Person.class);

//        Class xiaoming = personClazz.asSubclass(Person.class);
        System.out.println(ll.getName());

//        Class<? >
    }

}
