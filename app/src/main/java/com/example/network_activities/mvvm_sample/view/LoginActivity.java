package com.example.network_activities.mvvm_sample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.databinding.MvvmLayoutBinding;
import com.example.network_activities.mvvm_sample.model.AppLogin;

public class LoginActivity extends AppCompatActivity {

    MvvmLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MvvmLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(new AppLogin());
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }


}


