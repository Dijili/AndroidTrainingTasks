package com.example.network_activities.login.model;

import com.google.gson.annotations.SerializedName;


public class ValidateOTP {

    @SerializedName("MobileNo")
    public String mobileNo;
    public String deviceKey;
    @SerializedName("Otp")
    public String otp;
    @SerializedName("TokenizedOtp")
    public String tokenizedOtp;



}
