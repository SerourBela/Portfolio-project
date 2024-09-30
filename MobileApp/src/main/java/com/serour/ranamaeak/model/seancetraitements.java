package com.serour.ranamaeak.model;

public class seancetraitements {
    private int id;
    private int id_enfant;
    private String date;
    private String commentaire;
    private String conseils;

    public seancetraitements() {
    }

    public seancetraitements(int id, String date, String commentaire, String conseils) {
        this.id = id;
        this.date = date;
        this.commentaire = commentaire;
        this.conseils = conseils;
    }

    public int getId() {
        return id;
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getConseils() {
        return conseils;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setConseils(String conseils) {
        this.conseils = conseils;
    }

    public void setDate(String date) {
        this.date = date;
    }
}