package com.chris.ch1.annotest.t2;

public class TestInherited {

    public static void main(String[] args){

        Class<AnnoChildObj> annoChild = AnnoChildObj.class;
        Anno anno = annoChild.getAnnotation(Anno.class);
        System.out.println("annoation.name:" + anno.name());
    }
}
