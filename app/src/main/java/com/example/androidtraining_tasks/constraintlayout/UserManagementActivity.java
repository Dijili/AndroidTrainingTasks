package com.example.androidtraining_tasks.constraintlayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.UsermanagementMainBinding;

import java.util.ArrayList;

public class UserManagementActivity extends AppCompatActivity {

    UsermanagementMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UsermanagementMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Dialog dialog = new Dialog(this);

        binding.addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.removeroom_alert);
                dialog.show();
            }
        });

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.fa_solid_clinic_medical);
        images.add(R.drawable.group__1_);
        images.add(R.drawable.vector);
        images.add(R.drawable.solar_calendar_bold);
        images.add(R.drawable.mask_group);

        ArrayList<String> name = new ArrayList<>();
        name.add("Clinic Profile");
        name.add("User Management");
        name.add("Doc Consultation Config");
        name.add("Leave Management");
        name.add("Help Center");


        ArrayList<HouHeaderCardData> card_details = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int test_image = images.get(i % images.size());
            String test_name = name.get(i % name.size());
            card_details.add(new HouHeaderCardData(test_image, test_name));
        }
        binding.headerRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        HouHeaderCardAdapter adapter = new HouHeaderCardAdapter(card_details, this);
        binding.headerRecyclerview.setAdapter(adapter);
    }


}

