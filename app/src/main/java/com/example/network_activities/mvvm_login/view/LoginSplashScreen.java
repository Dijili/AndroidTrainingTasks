package com.example.network_activities.mvvm_login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.databinding.LoginSplashScreenBinding;
import com.example.network_activities.login.constants;
import com.example.network_activities.mvvm_login.model.UserProfileModel;
import com.google.gson.Gson;


public class LoginSplashScreen extends AppCompatActivity {
    LoginSplashScreenBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginSplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBar.setVisibility(View.VISIBLE);
                checkUserProfile();
            }
        });
    }

    private void checkUserProfile() {

        SharedPreferencesManager sharedPref = SharedPreferencesManager.getInstance(LoginSplashScreen.this);
        String userProfileJson = sharedPref.getString(constants.USER_PROFILE);

//        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        String userProfileJson = sharedPreferences.getString("UserProfile", null);

        if (userProfileJson != null) {
            Intent intent = new Intent(LoginSplashScreen.this, UserProfile.class);
            intent.putExtra(constants.USERPROFILE_JSON, new Gson().fromJson(userProfileJson, UserProfileModel.class));
            startActivity(intent);
        } else {
            navigationToMobileNumberScreen();
        }
    }

    public void navigationToMobileNumberScreen() {
        Intent intent = new Intent(LoginSplashScreen.this, MobileLoginScreen.class);
        startActivity(intent);
    }




}
