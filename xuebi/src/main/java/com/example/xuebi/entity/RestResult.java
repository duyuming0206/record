package com.example.xuebi.entity;

public class RestResult {

    Object obj;
    String stat;
    public void setObj(Object obj) {
        this.obj = obj;
    }
    public Object getObj() {
        return obj;
    }
    public void setStat(String stat) {
        this.stat = stat;
    }
    public String getStat() {
        return stat;
    }
    public RestResult(Object o) {
        this.obj=o;
    }
    public RestResult(Object o,String stat) {
        this.obj=o;
        this.stat=stat;
    }
}
