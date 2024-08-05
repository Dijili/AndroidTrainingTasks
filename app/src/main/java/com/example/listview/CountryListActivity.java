package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity {
    ArrayList<Country> countries = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_countries);
        listView = findViewById(R.id.countries_listView);
//        setData();
        setCountries();
        CountryListviewAdaptor listviewAdaptor = new CountryListviewAdaptor(this, countries);
        listView.setAdapter(listviewAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = (Country) parent.getItemAtPosition(position);
                Intent intent = new Intent(CountryListActivity.this, StatesListActivity.class);
                intent.putExtra("states", country.getStates());
                startActivity(intent);
            }
        });
    }


    private void setCountries() {
        Country india = new Country();
        india.countryName = "India";
        india.setCountryID(1);
        india.setStates(setIndiaStates());
//        india.countryID = 1;
//        india.states = setIndiaStates();
        countries.add(india);

        Country us = new Country();
        us.countryName = "China";
        us.setCountryID(2);
        us.setStates(setUsStates());
//        us.countryID = 2;
//        us.states = setUsStates();
        countries.add(us);
    }

    private ArrayList<String> setIndiaStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Andhra Pradesh");
        states.add("Telangana");
        states.add("Karnataka");
        states.add("Maharashtra");
        states.add("Uttar Pradesh");
        states.add("Assam");
        states.add("Bihar");
        states.add("Mizoram");
        states.add("Punjab");
        states.add("Kerala");
        return states;
    }

    private ArrayList<String> setUsStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Texas");
        states.add("California");
        states.add("Florida");
        states.add("Chicago");
        states.add("Sidney");
        return states;
    }

//    private ArrayList<String> setJapanStates() {
//        ArrayList<String> states = new ArrayList<>();
//        states.add("Hokkaido");
//        states.add("Tohoku");
//        states.add("Kanto");
//        states.add("Chubu");
//        states.add("Kyushu");
//        return states;
//    }


//    private void setData() {
//        countries.add("India");
//        countries.add("United States");
//        countries.add("Ireland");
//        countries.add("Finland");
//        countries.add("Japan");
//        countries.add("Russia");
//        countries.add("Poland");
//        countries.add("Canada");
//        countries.add("Italy");
//        countries.add("Germany");
//    }


}


