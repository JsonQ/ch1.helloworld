package com.chris.ch1.annotest.t2;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface Anno {
    String name() default "Chris";
}
