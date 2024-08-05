package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.FeedbackBottomcardBinding;
import com.example.androidtraining_tasks.databinding.FoeUserBinding;
import com.example.androidtraining_tasks.databinding.SummaryFragmentBinding;
import com.example.androidtraining_tasks.generated.callback.OnClickListener;

public class FoeFragment extends Fragment {
    FoeUserBinding binding;

//    FeedbackBottomcardBinding bottom_card;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FoeUserBinding.inflate(getLayoutInflater());

        binding.bottomCard.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UserManagementFragment = new UserManagementFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, UserManagementFragment);
                transaction.commit();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
