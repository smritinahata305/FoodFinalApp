package com.example.loginpage;

public class UserHelper {

    String name,password,phone,radius,username,category;

    public UserHelper() {

    }

    public UserHelper(String name, String password, String phone, String radius, String username,String category) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.radius = radius;
        this.username = username;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
