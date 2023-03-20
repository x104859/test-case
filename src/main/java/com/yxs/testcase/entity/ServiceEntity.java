package com.yxs.testcase.entity;

import java.util.Date;

/**
 * @author 洋小松
 * @date 2023/3/20
 */
public class ServiceEntity {
    private String a;
    private String b;
    private Date createdTime;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
