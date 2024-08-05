package com.example.network_activities.mvvm_sample.model;

public class AppLogin {

    String email, password;

//    public AppViewModel(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

    public AppLogin() {

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
