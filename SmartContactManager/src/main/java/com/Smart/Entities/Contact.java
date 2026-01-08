package com.Smart.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String secondName;
    private String work;
    private String email;
    private String phone;
    private String image;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    private User users;

    public Contact() {
    }

    public Contact(String description, String email, int id, String image, String name, String phone, String secondName, String work) {
        this.description = description;
        this.email = email;
        this.id = id;
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.secondName = secondName;
        this.work = work;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
