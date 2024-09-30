package com.serour.ranamaeak.model;

import java.util.Date;

public class notifications {
    private int id;
    private Date date;
    private int etat;
    private  String detail;

    public notifications(int id, Date date, int etat, String detail) {
        this.id = id;
        this.date = date;
        this.etat = etat;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getEtat() {
        return etat;
    }

    public String getDetail() {
        return detail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
