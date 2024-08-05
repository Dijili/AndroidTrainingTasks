package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.ClinicprofileFragmentBinding;
import com.example.androidtraining_tasks.databinding.UpdateClinicprofileBinding;

import java.util.ArrayList;

public class UpdateClinicProfileFragment extends Fragment {

    UpdateClinicprofileBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = UpdateClinicprofileBinding.inflate(getLayoutInflater());

        return binding.getRoot();
}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }
}
