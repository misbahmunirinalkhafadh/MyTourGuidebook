package com.dikoding.picodiploma.mytourguidebook.model;

public class Wisata {
    private String city, country, description, image, location, posted_by, posted_time, summary, title;

    public Wisata() {
    }

    public Wisata(String city, String country, String description, String image, String location, String posted_by, String posted_time, String summary, String title) {
        this.city = city;
        this.country = country;
        this.description = description;
        this.image = image;
        this.location = location;
        this.posted_by = posted_by;
        this.posted_time = posted_time;
        this.summary = summary;
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(String posted_by) {
        this.posted_by = posted_by;
    }

    public String getPosted_time() {
        return posted_time;
    }

    public void setPosted_time(String posted_time) {
        this.posted_time = posted_time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
