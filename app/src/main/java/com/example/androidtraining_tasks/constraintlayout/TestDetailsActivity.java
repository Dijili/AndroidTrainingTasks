package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.TestDetailsRecyclerviewBinding;
import com.example.androidtraining_tasks.databinding.TestdetailsCardBinding;

import java.util.ArrayList;

public class TestDetailsActivity extends AppCompatActivity {


    TestDetailsRecyclerviewBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TestDetailsRecyclerviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView recyclerView = findViewById(R.id.testdetails_recyclerview);


        ArrayList<String> test_name = new ArrayList<>();
        test_name.add("AFB Smear,Slit Skin Group:Microbiology,TAT:6hrs");
        test_name.add("AFB Smear,Slit Skin Group:Microbiology,TAT:6hrs");
        test_name.add("AFB Smear,Slit Skin Group:Microbiology,TAT:6hrs");
        test_name.add("AFB Smear,Slit Skin Group:Microbiology,TAT:6hrs");

        ArrayList<String> code = new ArrayList<>();
        code.add("S1279");
        code.add("S1858");
        code.add("S1999");
        code.add("S1636");

        ArrayList<String> sample = new ArrayList<>();
        sample.add("Slit Skin");
        sample.add("Slit Skin");
        sample.add("Slit Skin");
        sample.add("Slit Skin");

        ArrayList<TestDetailsData> test_details = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String testname = test_name.get(i % test_name.size());
            String testcode = code.get(i % code.size());
            String testsample = sample.get(i % sample.size());
            test_details.add(new TestDetailsData(testname, testcode, testsample));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        TestDetailsAdapter adapter = new TestDetailsAdapter(test_details, this);
        recyclerView.setAdapter(adapter);

    }

}
