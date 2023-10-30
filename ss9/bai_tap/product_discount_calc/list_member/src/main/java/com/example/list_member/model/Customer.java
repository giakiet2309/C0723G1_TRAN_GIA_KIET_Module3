package com.example.list_member.model;

import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate birthday;
    private String adress;
    private String linkPicture;

    public Customer(String name, LocalDate birthday, String adress) {
        this.name = name;
        this.birthday = birthday;
        this.adress = adress;
    }

    public Customer(String name, LocalDate birthday, String adress, String linkPicture) {
        this.name = name;
        this.birthday = birthday;
        this.adress = adress;
        this.linkPicture = linkPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }
}
