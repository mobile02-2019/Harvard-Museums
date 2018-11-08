package com.example.andreza.harvardmuseums.pojo;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Artwork implements Serializable {

    private int id;

    @SerializedName("title")
    private String title;
    @SerializedName("primaryimageurl")
    private String picture; //Mudei aqui de ImageView para String para poder utilizar a URL
    @SerializedName("classification")
    private String classification;
    /*@SerializedName("worktypes") //TODO erro: IllegalArgumentException: No suitable parent found from the given view. Please provide a valid view.
    private String worktype;*/
   @SerializedName("dated")
    private String date;
     // não encontrei place no /object da api
    private String placeCreation;
    @SerializedName("period")
    private String period;
    @SerializedName("culture")
    private String culture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

   /* public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlaceCreation() {
        return placeCreation;
    }

    public void setPlaceCreation(String placeCreation) {
        this.placeCreation = placeCreation;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }
}
