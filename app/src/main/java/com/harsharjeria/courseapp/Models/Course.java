package com.harsharjeria.courseapp.Models;

public class Course {

    public String namecourse, idcourse, linkcourse, iconlink, priceAmount, courseDesc;
    public double ratings, views;
    public int website;

    public Course() {}

    public Course(String namecourse, String idcourse, String linkcourse, String iconlink, int website, double ratings, double views, String priceAmount, String courseDesc) {
        this.namecourse = namecourse;
        this.idcourse = idcourse;
        this.linkcourse = linkcourse;
        this.iconlink = iconlink;
        this.website = website;
        this.ratings = ratings;
        this.priceAmount = priceAmount;
        this.courseDesc = courseDesc;
        this.views = views;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }

    public String getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(String idcourse) {
        this.idcourse = idcourse;
    }

    public String getLinkcourse() {
        return linkcourse;
    }

    public void setLinkcourse(String linkcourse) {
        this.linkcourse = linkcourse;
    }

    public String getIconlink() {
        return iconlink;
    }

    public void setIconlink(String iconlink) {
        this.iconlink = iconlink;
    }

    public String getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(String priceAmount) {
        this.priceAmount = priceAmount;
    }

    public int getWebsite() {
        return website;
    }

    public void setWebsite(int website) {
        this.website = website;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public double getViews() {
        return views;
    }

    public void setViews(double views) {
        this.views = views;
    }
}
