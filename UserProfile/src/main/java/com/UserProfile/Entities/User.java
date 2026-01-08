package com.UserProfile.Entities;


import jakarta.persistence.*;

@jakarta.persistence.Entity
@Table(name="entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_Id",referencedColumnName = "I_d")
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
