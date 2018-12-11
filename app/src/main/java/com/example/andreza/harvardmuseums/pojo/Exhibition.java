package com.example.andreza.harvardmuseums.pojo;

import com.example.andreza.harvardmuseums.pojo.ImageExhibition;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Exhibition implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("begindate")
    private String beginDate;
    @SerializedName("enddate")
    private String endDate;
//    @SerializedName("")
    private String local;
    @SerializedName("textiledescription")
    private String description;
    @SerializedName("primaryimageurl")
    private String imagemDaExibicao;
    @SerializedName("images")
    private List<ImageExhibition> image;
    @SerializedName("venues")
    private List<VenueAddress> address;

    public String getImagemDaExibicao() {
        return imagemDaExibicao;
    }

    public void setImagemDaExibicao(String imagemDaExibicao) {
        this.imagemDaExibicao = imagemDaExibicao;
    }

    public List<VenueAddress> getAddress() {
        return address;
    }

    public void setAddress(List<VenueAddress> address) {
        this.address = address;
    }

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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
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


    public List<ImageExhibition> getImage() {
        return image;
    }

    public void setImage(List<ImageExhibition> image) {
        this.image = image;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}