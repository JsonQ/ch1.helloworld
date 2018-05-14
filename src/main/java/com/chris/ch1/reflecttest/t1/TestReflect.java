package com.chris.ch1.reflecttest.t1;

public class TestReflect {

    public static void main(String[] args) throws Exception{

        Class<Person> personClazz = Person.class;
//        System.out.println(personClazz.getName());
//        Class<XiaoMing> xiaomingClazz = XiaoMing.class;
//        System.out.println(xiaomingClazz.getName());
//
//        Person personObj = new Person();
//        XiaoMing xiaomingObj = new XiaoMing();
//
//        Class<? extends Person> ll = xiaomingClazz.asSubclass(Person.class);
//
//        System.out.println(ll.getName());


        Class<?> clazz = Class.forName("com.chris.ch1.reflecttest.t1.XiaoMing");
        XiaoMing xiaoming = (XiaoMing)clazz.newInstance();
        xiaoming.playFootball();

        ClassLoader classLoader = personClazz.getClassLoader();
//        classLoader.


    }

}
