package com.example.androidtraining_tasks.constraintlayout;

public class OutPatientData {


    public String name;
    public String opid;
    public String gender;
    public String age;

    public OutPatientData(String name, String opid, String gender, String age) {
        this.name = name;
        this.opid = opid;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
