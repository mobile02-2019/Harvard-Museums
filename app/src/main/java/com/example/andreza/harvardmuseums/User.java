package com.example.andreza.harvardmuseums;

import com.example.andreza.harvardmuseums.pojo.Artwork;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private List<Artwork> artworkList = new ArrayList<>();

    public User(){

    }

    public User(List<Artwork> artworkList) {
        this.artworkList = artworkList;
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Artwork> getArtworkList() {
        return artworkList;
    }

    public void setArtworkList(List<Artwork> artworkList) {
        this.artworkList = artworkList;
    }
}
