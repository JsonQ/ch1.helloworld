package com.chris.ch1.reflecttest.t1;

public class XiaoMing extends Person implements Play {

    private String parents;

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    @Override
    public void playFootball() {
        System.out.println("XiaoMing play football!");
    }
}
