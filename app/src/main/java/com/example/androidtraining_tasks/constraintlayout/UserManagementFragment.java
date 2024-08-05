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
import com.example.androidtraining_tasks.databinding.UsermanagementRecyclerviewBinding;

import java.util.ArrayList;


public class UserManagementFragment extends Fragment {

    private RecyclerView recyclerView;

    UsermanagementRecyclerviewBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = UsermanagementRecyclerviewBinding.inflate(getLayoutInflater());
        binding.addUsers.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Fragment FoeFragment = new FoeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, FoeFragment);
//                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ArrayList<String> name = new ArrayList<>();
        name.add("Lohit Kumar Dokula");
        name.add("Kumari Sandya");
        name.add("Dr.Rohit Prasad");


        ArrayList<String> role = new ArrayList<>();
        role.add("PHYSIOTHERAPIST");
        role.add("NURSING SPECIALIST");
        role.add("DOCTOR");


        ArrayList<UserManagementModel> user_details = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            String test_name = name.get(i % name.size());
            String test_role = role.get(i % role.size());
            user_details.add(new UserManagementModel(test_name, test_role));
        }

//        binding.userManagementRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.userManagementRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        UserManagementAdapter adapter = new UserManagementAdapter(user_details, this);
        binding.userManagementRecyclerview.setAdapter(adapter);


    }


//    private void replaceFragment(Fragment fragment) {
//
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit();
//    }


}
