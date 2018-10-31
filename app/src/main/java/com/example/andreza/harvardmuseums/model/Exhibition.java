package com.example.andreza.harvardmuseums.model;

import java.io.Serializable;

public class Exhibition implements Serializable {

    private String title;
    private String date;
    private String local;
    private String description;
    private String image;
    private int imagemDetalhes;

    public int getImagemDetalhes() {
        return imagemDetalhes;
    }

    public void setImagemDetalhes(int imagemDetalhes) {
        this.imagemDetalhes = imagemDetalhes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}