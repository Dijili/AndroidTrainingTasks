package com.example.listview_countries;

import java.util.ArrayList;

public class Country {
    public int countryID;
    public String countryName;
    public ArrayList<String> states;

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<String> getStates() {
        return states;
    }


    public void setStates(ArrayList<String> states) {
        this.states = states;
    }

}

