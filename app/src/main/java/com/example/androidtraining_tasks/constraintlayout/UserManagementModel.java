package com.example.androidtraining_tasks.constraintlayout;

public class UserManagementModel {
    public String name;
    public String role;

    public UserManagementModel(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
