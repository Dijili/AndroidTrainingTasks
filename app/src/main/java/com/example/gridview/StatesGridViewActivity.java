package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;


public class StatesGridViewActivity extends AppCompatActivity {
    ArrayList<String> states = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_states);
        GridView gridView = findViewById(R.id.grid_view);
        states = (ArrayList<String>) getIntent().getSerializableExtra("states");
        StatesAdapter statesGridViewAdapter = new StatesAdapter(this, states);
        gridView.setAdapter(statesGridViewAdapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(getBaseContext( ), "Selected User " + (states.EmployeeName),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the clicked item from the ArrayList
                String clickedText = states.get(position);

                // Display toast message
                Toast.makeText(StatesGridViewActivity.this, clickedText + " is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}









