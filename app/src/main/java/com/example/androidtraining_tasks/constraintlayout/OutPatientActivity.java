package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.OutpatientsCardBinding;

import java.util.ArrayList;

public class OutPatientActivity extends AppCompatActivity {
    OutpatientsCardBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OutpatientsCardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView recyclerView = findViewById(R.id.outpatient_recyclerview);


        ArrayList<String> name = new ArrayList<>();
        name.add("kumari Ramajan");
        name.add("Kavya Pydi");
        name.add("Latha Srinivasan");
        name.add("Lalli Kiran");

        ArrayList<String> opid = new ArrayList<>();
        opid.add("#OP1234789");
        opid.add("#OP4567878");
        opid.add("#OP7889899");
        opid.add("#OP3786745");

        ArrayList<String> gender = new ArrayList<>();
        gender.add("| F |");
        gender.add("| F |");
        gender.add("| F |");
        gender.add("| F |");



        ArrayList<String> age = new ArrayList<>();
        age.add("40yrs");
        age.add("30yrs");
        age.add("50yrs");
        age.add("28yrs");

        ArrayList<OutPatientData> op_vitals = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String person_name = name.get(i % name.size());
            String person_opid = opid.get(i % opid.size());
            String person_gender = gender.get(i % gender.size());
            String person_age = age.get(i % name.size());
            op_vitals.add(new OutPatientData(person_name, person_opid, person_gender, person_age));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        OutPatientAdapter adapter = new OutPatientAdapter(op_vitals, this);
        recyclerView.setAdapter(adapter);
    }
}
