package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;

import com.example.androidtraining_tasks.databinding.HouClinicFormBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class HouClinicActivity extends AppCompatActivity {

    HouClinicFormBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HouClinicFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        BottomSheetDialog bottom_dialog = new BottomSheetDialog(this);

        binding.dashes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_dialog.setContentView(R.layout.upload_docs_bottomsheet);
                bottom_dialog.show();

            }
        });

        ArrayList<String> labtest_name = new ArrayList<>();
        labtest_name.add("Smear,Pus,Code:S1283,Group:Microbiology,TAT:6hrs4321");



        ArrayList<String> status = new ArrayList<>();
        status.add("Completed");


        ArrayList<HouClinicData> lab_details = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String test_name = labtest_name.get(i % labtest_name.size());
            String test_status = status.get(i % status.size());
            lab_details.add(new HouClinicData(test_name, test_status));
        }

        binding.houClinicRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        HouClinicAdapter adapter = new HouClinicAdapter(lab_details, this);
        binding.houClinicRecyclerview.setAdapter(adapter);


    }
}
