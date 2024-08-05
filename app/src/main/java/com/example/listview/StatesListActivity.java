package com.example.listview;

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
        ListView listView = findViewById(R.id.states_listView);
//        setData();

        states = (ArrayList<String>) getIntent().getSerializableExtra("states");
        StatesListViewAdaptor countryListViewAdaptor = new StatesListViewAdaptor(this, states);
        listView.setAdapter(countryListViewAdaptor);
    }


//    private void setData() {
//        states.add("Andhra Pradesh");
//        states.add("Telangana");
//        states.add("Karnataka");
//        states.add("Maharashtra");
//        states.add("Uttar Pradesh");
//        states.add("Assam");
//        states.add("Bihar");
//        states.add("Mizoram");
//        states.add("Punjab");
//        states.add("Kerala");
//    }
}
