package com.chris.ch1.annotest.t1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface FieldMeta {
    boolean id() default false;
    String name() default "";
    boolean editable() default true;
    boolean summary() default true;
    String description() default "";
    int order() default 0;
}
