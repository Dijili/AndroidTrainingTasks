package com.example.network_activities.mvvm_login.model;

import java.io.Serializable;

public class RequestOTP implements Serializable {

    public String mobileNo;
    public boolean isResend;
    public String deviceKey;
    public String secretKey;
    public String applicationID;

}
