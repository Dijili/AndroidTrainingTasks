package com.example.androidtraining_tasks.constraintlayout;

public class HouClinicData {

    public String labtest_name;
    public String status;

    public HouClinicData(String labtest_name, String status) {
        this.labtest_name = labtest_name;
        this.status = status;
    }

    public String getLabtest_name() {
        return labtest_name;
    }

    public void setLabtest_name(String labtest_name) {
        this.labtest_name = labtest_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
