package com.example.network_activities.mvvm_sample.model;

import androidx.annotation.Nullable;

public class Model {
    @Nullable
    String email, password;

    public Model(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }


    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
