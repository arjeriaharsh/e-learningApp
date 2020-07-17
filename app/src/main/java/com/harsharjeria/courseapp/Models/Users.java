package com.harsharjeria.courseapp.Models;

public class Users {
    public String uid, name, email, qualification;
    public int permLevel;

    public Users(){}

    public Users(String uid, String name, String email, String qualification, int permLevel) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.permLevel = permLevel;
    }

    public Users (String qualification){
        this.qualification = qualification;
    }

    public int getPermLevel() {
        return permLevel;
    }

    public void setPermLevel(int permLevel) {
        this.permLevel = permLevel;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}

