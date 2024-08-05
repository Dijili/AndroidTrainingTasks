package com.example.listview_countries;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;

public class StatesListActivity extends AppCompatActivity {

    ArrayList<String> states = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_states);
        ListView listView = findViewById(R.id.listView);
//        setData();


        states = (ArrayList<String>) getIntent().getSerializableExtra("states");
        StatesListAdapter countryListViewAdaptor = new StatesListAdapter(this, states);
        listView.setAdapter(countryListViewAdaptor);

    }

}