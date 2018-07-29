package com.qfedu.domain;

import java.util.Date;

public class Quest {

    private int id;
    private String quest;
    private Date createtime;
    private int answer;
    private int createuid;
    private int flag;
    private String qtname;
    private String uname;
    private  int qtid;

    public int getQtid() {
        return qtid;
    }

    public void setQtid(int qtid) {
        this.qtid = qtid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getQtname() {
        return qtname;
    }

    public void setQtname(String qtname) {
        this.qtname = qtname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getCreateuid() {
        return createuid;
    }

    public void setCreateuid(int createuid) {
        this.createuid = createuid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
