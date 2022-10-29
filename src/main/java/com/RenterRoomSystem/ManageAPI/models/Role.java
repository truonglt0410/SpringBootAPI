package com.RenterRoomSystem.ManageAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private Integer id;
    private String role;
//    private String rolename;



    public Role() {
    }

    public Role(String role) {
        this.role = role;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){this.id = id;}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
