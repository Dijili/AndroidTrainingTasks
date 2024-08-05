package com.example.network_activities.mvvm_login.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestOTPResponse implements Serializable {


    @SerializedName("MobileNo")
    public String mobileNo;

    @SerializedName("Email")
    public String email;

    @SerializedName("TokenizedOTP")
    public String tokenizedOTP;

    @SerializedName("StatusCode")
    public String statusCode;

    @SerializedName("ConsentFor")
    public String consentFor;

}
