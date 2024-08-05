package com.example.recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;


import java.util.ArrayList;

public class CountryRecyclerViewActivity extends AppCompatActivity {

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_countries);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.countries_recyclerview);
        int Spancount = 2;

        // data to populate the RecyclerView with
        ArrayList<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("US");
        countries.add("Japan");
        countries.add("Ireland");
        countries.add("Denmark");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.student_light_skin_tone_svgrepo_com);
        images.add(R.drawable.student_light_skin_tone_svgrepo_com);
        images.add(R.drawable.student_light_skin_tone_svgrepo_com);
        images.add(R.drawable.student_light_skin_tone_svgrepo_com);
        images.add(R.drawable.student_light_skin_tone_svgrepo_com);
        images.add(R.drawable.student_light_skin_tone_svgrepo_com);

        //LinearLayoutManager
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(new RecyclerViewAdapter(countries, this));

//        //GridLayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, Spancount));
        recyclerView.setAdapter(new RecyclerViewAdapter(countries, this,images));

        //StaggeredGridLayout
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Spancount, StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setAdapter(new RecyclerViewAdapter(countries, this, images));


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        dividerItemDecoration.setDrawable(getDrawable(android.R.drawable.menuitem_background));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

}
