package com.example.listview_countries;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_countries);
        ListView listView = findViewById(R.id.listView);
//        setData();
        setCountries();
        CountryListAdapter listviewAdaptor = new CountryListAdapter(this, countries);
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
        countries.add(india);


        Country us = new Country();
        us.countryName = "US";
        us.setCountryID(2);
        us.setStates(setUsStates());
        countries.add(us);

        Country china = new Country();
        china.countryName = "China";
        china.setCountryID(3);
        china.setStates(setChinaStates());
        countries.add(china);

        Country ireland = new Country();
        ireland.countryName = "Ireland";
        ireland.setCountryID(4);
        ireland.setStates(setIrelandStates());
        countries.add(ireland);

        Country japan = new Country();
        japan.countryName = "Japan";
        japan.setCountryID(5);
        japan.setStates(setJapanStates());
        countries.add(japan);
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

    private ArrayList<String> setChinaStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Hainan");
        states.add("Fujian");
        states.add("Yunnan");
        states.add("Sichuan");
        states.add("Jiangsu");
        return states;
    }

    private ArrayList<String> setIrelandStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Kerry");
        states.add("Meath");
        states.add("Cork");
        states.add("Ulster");
        states.add("Dublin");
        return states;
    }

    private ArrayList<String> setJapanStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Hokkaido");
        states.add("Chubu");
        states.add("Chiba");
        states.add("Kansai");
        states.add("Tokyo");
        return states;

    }






}
