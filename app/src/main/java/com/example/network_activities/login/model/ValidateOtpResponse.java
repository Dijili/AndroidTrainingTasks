package com.example.network_activities.login.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ValidateOtpResponse implements Serializable {

    @SerializedName("StatusCode")
    public String statusCode;

    @SerializedName("StatusMessage")
    public String statusMessage;

    @SerializedName("UserProfile")
    public UserProfileModel userProfile;

}

