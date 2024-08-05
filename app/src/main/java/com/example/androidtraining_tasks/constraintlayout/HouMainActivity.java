package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.MainFragmentLayoutBinding;

import java.util.ArrayList;

public class HouMainActivity extends AppCompatActivity {

    MainFragmentLayoutBinding binding;

    HouHeaderCardAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainFragmentLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.summary_svgrepo_com);
        images.add(R.drawable.fa_solid_clinic_medical);
        images.add(R.drawable.group__1_);
        images.add(R.drawable.cbi_rooms_front_door);
        images.add(R.drawable.vector);
        images.add(R.drawable.solar_calendar_bold);
        images.add(R.drawable.mask_group);

        ArrayList<String> name = new ArrayList<>();
        name.add("Summary");
        name.add("Clinic Profile");
        name.add("User Management");
        name.add("Consultation Room");
        name.add("Settings");
        name.add("Doc Consultation Config");
        name.add("Leave Management");
        name.add("Help Center");

        ArrayList<HouHeaderCardData> card_details = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int test_image = images.get(i % images.size());
            String test_name = name.get(i % name.size());
            card_details.add(new HouHeaderCardData(test_image, test_name));
        }


        adapter = new HouHeaderCardAdapter(card_details, this);
        binding.headerRecyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(new HouHeaderCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        replaceFragment(new SummaryFragment());
                        break;
                    case 1:
                        replaceFragment(new ClinicProfileFragment());
                        break;
                    case 2:
                        replaceFragment(new UserManagementFragment());
                        break;
                    case 3:
                        replaceFragment(new ConsultationBoardFragment());
                        break;
                    case 4:
                        replaceFragment(new SettingsFragment());
                        break;

                }
            }
        });


        binding.headerRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        replaceFragment(new ClinicProfileFragment());
    }

    private void replaceFragment(Fragment fragment) {


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

}
