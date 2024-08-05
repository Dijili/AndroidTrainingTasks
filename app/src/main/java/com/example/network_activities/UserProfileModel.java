package com.example.network_activities;

import java.io.Serializable;

public class UserProfileModel implements Serializable {

    String UserID;

    String FirstName;

    String LastName;

    String MobileNumber;

    public String getUserID() {
        return UserID;
    }


    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMobileNo() {
        return MobileNumber;
    }

    public void setMobileNo(String mobileNo) {
        MobileNumber = mobileNo;
    }


}
