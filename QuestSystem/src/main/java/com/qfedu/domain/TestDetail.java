package com.qfedu.domain;

public class TestDetail {
    private  int id;
    private int tid;
    private int qid;
    private int istf;
    private String uanswer;

    public String getUanswer() {
        return uanswer;
    }

    public void setUanswer(String uanswer) {
        this.uanswer = uanswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getIstf() {
        return istf;
    }

    public void setIstf(int istf) {

        this.istf = istf;
    }

    @Override
    public String toString() {
        return "TestDetail{" +
                "id=" + id +
                ", tid=" + tid +
                ", pid=" + qid +
                ", istf=" + istf +
                ", uanswer='" + uanswer + '\'' +
                '}';
    }
}
