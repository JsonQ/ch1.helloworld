package com.chris.ch1.validated;

import com.chris.ch1.annotation.WorkOverTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {

    private WorkOverTime work;
    private int max;

    @Override
    public void initialize(WorkOverTime constraintAnnotation) {
        // 获取注解的定义
        this.work = constraintAnnotation;
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 校验逻辑
        if(value == null){
            return true;
        }
        return value < max;
    }
}
