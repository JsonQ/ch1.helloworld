package com.chris.ch1.annotest.t1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parent<T> {

    private Class<T> entity;

    public Parent(){
        init();
    }

    @SuppressWarnings("unchecked")
    public List<SortableField> init(){
        List<SortableField> list = new ArrayList<SortableField>();
        Class clazz = this.getClass();
        Type pType = clazz.getGenericSuperclass();
        ParameterizedType aParamridType = (ParameterizedType)pType;
        Type[] type = aParamridType.getActualTypeArguments();
        this.entity = (Class<T>)type[0];

        if(this.entity != null){
            Field[] fields = this.entity.getDeclaredFields();
            for(Field f : fields){
                FieldMeta meta = f.getAnnotation(FieldMeta.class);
                if(meta != null){
                    SortableField sf = new SortableField(meta, f);
                    list.add(sf);
                }
            }

            Method[] methods = this.entity.getDeclaredMethods();
            for(Method m : methods){
                FieldMeta meta = m.getAnnotation(FieldMeta.class);
                if(meta != null){
                    SortableField sf = new SortableField(meta, m.getName(), m.getReturnType());
                    list.add(sf);
                }
            }

            Collections.sort(list, new Comparator<SortableField>(){
                @Override
                public int compare(SortableField o1, SortableField o2) {
                    return o1.getMeta().order() - o2.getMeta().order();
                }
            });
        }
        return list;
    }
}
