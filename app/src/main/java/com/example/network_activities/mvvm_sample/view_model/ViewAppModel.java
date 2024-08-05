package com.example.network_activities.mvvm_sample.view_model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ViewAppModel extends BaseObservable {


    private ViewAppModel model;


    public void setUserEmail(String email) {
        model.setUserEmail(email);
    }

    @Bindable
    public String getUserEmail() {
        return model.getUserEmail();
    }

    @Bindable
    public String getUserPassword() {
        return model.getUserPassword();
    }

    public void setUserPassword(String password) {
        model.setUserEmail(password);
    }

    public ViewAppModel() {
        model = new ViewAppModel();
    }

}


