package com.example.andreza.harvardmuseums.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VenueAddress implements Serializable {
    @SerializedName("zipcode")
    private String cep;
    @SerializedName("state")
    private String estado;
    @SerializedName("address1")
    private String endereco;
    @SerializedName("city")
    private String cidade;

    @Override
    public String toString() {
        return
                endereco + ", " + cidade + ", " + estado + ", " + cep;


    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
