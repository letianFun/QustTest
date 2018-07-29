package com.qfedu.domain;

import java.util.Date;

public class Test {
    private int id;
    private int uid;
    private Date starttime;
    private Date endtime;
    private int questnum;
    private int flag;
    private String uname;
    private int truenum;
    private int urole;

    public int getUrole() {
        return urole;
    }

    public void setUrole(int urole) {
        this.urole = urole;
    }

    public int getTruenum() {
        return truenum;
    }

    public void setTruenum(int truenum) {
        this.truenum = truenum;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getQuestnum() {
        return questnum;
    }

    public void setQuestnum(int questnum) {
        this.questnum = questnum;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", uid=" + uid +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", questnum=" + questnum +
                ", flag=" + flag +
                ", uname='" + uname + '\'' +
                ", truenum=" + truenum +
                ", urole=" + urole +
                '}';
    }
}
