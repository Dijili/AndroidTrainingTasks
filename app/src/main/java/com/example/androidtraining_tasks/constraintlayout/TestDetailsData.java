package com.example.androidtraining_tasks.constraintlayout;

public class TestDetailsData {

    public String test_name;
    public String code;
    public String sample;


    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public TestDetailsData(String test_name, String code, String sample ){
        this.test_name=test_name;
        this.code=code;
        this.sample=sample;

    }


}
