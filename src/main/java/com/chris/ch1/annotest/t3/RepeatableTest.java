package com.chris.ch1.annotest.t3;

import java.lang.annotation.Annotation;

public class RepeatableTest {
    public static void main(String[] args){
//        Class<SuperMan> clazz = SuperMan.class;
//        Persons persons = clazz.getAnnotation(Persons.class);
//        Person[] arrayPerson = persons.value();
//        for(Person p : arrayPerson){
//            System.out.println(p.role());
//        }

        SuperMan superMan = new SuperMan();
        Class clz = superMan.getClass();
        Annotation anno = clz.getAnnotation(Persons.class);
        Persons ps = (Persons)anno;
        for(Person p : ps.value()) {
            System.out.println(p.role());
        }

    }
}
