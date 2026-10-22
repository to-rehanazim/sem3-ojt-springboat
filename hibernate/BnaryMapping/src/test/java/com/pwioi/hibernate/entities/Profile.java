package com.pwioi.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table
public class Profile {

    @Id
    private int id;

    private String name;

    @Lob
    private byte[] photo;

    @Lob
    private char[] resume;

    public Profile() {
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public char[] getResume() {
        return resume;
    }

    public void setResume(char[] resume) {
        this.resume = resume;
    }
}