package com.serour.ranamaeak.model;

import java.util.Date;

public class remarques {
    private int id;
    private int id_parent;
    private Date date;
    private String detail;
    public remarques() {
    }

    public int getId() {
        return id;
    }

    public int getId_parent() {
        return id_parent;
    }

    public Date getDate() {
        return date;
    }

    public String getDetail() {
        return detail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
