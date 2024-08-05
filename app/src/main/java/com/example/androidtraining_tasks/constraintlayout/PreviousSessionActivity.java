package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.PreviousSessionsCardBinding;


public class PreviousSessionActivity extends AppCompatActivity {

    PreviousSessionsCardBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice);
//        binding = PreviousSessionsCardBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

    }
}
