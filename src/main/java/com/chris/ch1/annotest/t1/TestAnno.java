package com.chris.ch1.annotest.t1;

import java.util.List;

public class TestAnno {

    public static void main(String[] args){
        Parent              c    = new Child();
        List<SortableField> list = c.init();

        for(SortableField l : list){
            System.out.println("字段名称：" + l.getName());
            System.out.println("字段类型：" + l.getType());
            System.out.println("注解名称：" + l.getMeta());
            System.out.println("注解描述：" + l.getMeta().description());
        }
    }
}
