package com.example.androidtraining_tasks.constraintlayout;

public class ClinicProfileModel {
    public int image;
    public String clinic_center;
    public String location;
    public String mobile_num;
    public String confirmation;
    public String address;

    public ClinicProfileModel(int image,String clinic_center,String location, String mobile_num,String confirmation,String address){

        this.image=image;
        this.clinic_center=clinic_center;
        this.location=location;
        this.mobile_num=mobile_num;
        this.confirmation=confirmation;
        this.address=address;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getClinic_center() {
        return clinic_center;
    }

    public void setClinic_center(String clinic_center) {
        this.clinic_center = clinic_center;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
