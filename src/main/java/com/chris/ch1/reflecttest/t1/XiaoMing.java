package com.chris.ch1.reflecttest.t1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class XiaoMing extends Person implements Play {

    private String parents;
    private Date   birthday;

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    @Override
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    @Override
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void playFootball() {
        System.out.println("XiaoMing play football!");
    }
}
