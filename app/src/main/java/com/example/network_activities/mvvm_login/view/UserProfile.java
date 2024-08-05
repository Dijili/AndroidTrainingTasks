package com.example.network_activities.mvvm_login.view;

import static com.example.network_activities.login.constants.USERPROFILE_JSON;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidtraining_tasks.databinding.UserProfileDetailsBinding;
import com.example.network_activities.mvvm_login.model.UserProfileModel;


public class UserProfile extends AppCompatActivity {
    UserProfileDetailsBinding binding;
    UserProfileModel data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UserProfileDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        data = (UserProfileModel) getIntent().getSerializableExtra(USERPROFILE_JSON);
        binding.setUser(data);
    }
}
