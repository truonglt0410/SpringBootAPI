package com.RenterRoomSystem.ManageAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//pojo = plain object java object
@Entity
public class Building {
    //this is "primary key"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private int id;
    private String name;
    private String phone;
    private String image;
    private String description;
    private String utilties;
    private String rule;
    private int code_address;

    public Building() {
    }

    public Building( String name, String phone, String image, String description, String utilties, String rule, int code_address) {
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.description = description;
        this.utilties = utilties;
        this.rule = rule;
        this.code_address = code_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUtilties() {
        return utilties;
    }

    public void setUtilties(String utilties) {
        this.utilties = utilties;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getCode_address() {
        return code_address;
    }

    public void setCode_address(int code_address) {
        this.code_address = code_address;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", utilties='" + utilties + '\'' +
                ", rule='" + rule + '\'' +
                ", code_address=" + code_address +
                '}';
    }
}
