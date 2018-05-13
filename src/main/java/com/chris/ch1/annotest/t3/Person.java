package com.chris.ch1.annotest.t3;

import java.lang.annotation.*;

@Repeatable(Persons.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Person {

    String role() default "";
}
