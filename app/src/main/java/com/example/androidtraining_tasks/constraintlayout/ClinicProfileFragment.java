package com.example.androidtraining_tasks.constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.ClinicprofileCardBinding;
import com.example.androidtraining_tasks.databinding.ClinicprofileFragmentBinding;


import java.util.ArrayList;

public class ClinicProfileFragment extends Fragment {

    private RecyclerView recyclerView;

    ClinicprofileFragmentBinding binding;

//    ClinicprofileCardBinding card_binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = ClinicprofileFragmentBinding.inflate(getLayoutInflater());
//        card_binding = ClinicprofileCardBinding.inflate(getLayoutInflater());

        binding.addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UpdateClinicProfileFragment = new UpdateClinicProfileFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, UpdateClinicProfileFragment);
                transaction.commit();
            }
        });

        binding.background.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.fa_solid_clinic_medical);
        images.add(R.drawable.group__1_);

        ArrayList<String> clinic_center = new ArrayList<>();
        clinic_center.add("People Care Wellness Center");
        clinic_center.add("Medical Care");

        ArrayList<String> location = new ArrayList<>();
        location.add("Madhapur");
        location.add("Hyderabad");


        ArrayList<String> mobile_num = new ArrayList<>();
        mobile_num.add("+91 9636936989");
        mobile_num.add("+91 8529639632");

        ArrayList<String> confirmation = new ArrayList<>();
        confirmation.add("Yes");
        confirmation.add("No");

        ArrayList<String> address = new ArrayList<>();
        address.add("1-92,kavuri Hills Rd, kummari Basti, Vital Rao Nagar,Madhapur,Hyderabad-500081");
        address.add("Moosapet");


        ArrayList<ClinicProfileModel> card_details = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int test_image = images.get(i % images.size());
            String clinic = clinic_center.get(i % clinic_center.size());
            String test_location = location.get(i % location.size());
            String mobile = mobile_num.get(i % mobile_num.size());
            String test_confirm = confirmation.get(i % confirmation.size());
            String test_address = address.get(i % address.size());
            card_details.add(new ClinicProfileModel(test_image, clinic, test_location, mobile, test_confirm, test_address));
        }
        binding.clinicProfileRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
//        binding.clinicProfileRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ClinicProfileAdapter adapter = new ClinicProfileAdapter(card_details, this);
        binding.clinicProfileRecyclerview.setAdapter(adapter);
    }

}

