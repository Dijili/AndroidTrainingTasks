package com.example.network_activities.mvvm_login.view;

import static com.example.network_activities.login.constants.MOBILE_NO;
import static com.example.network_activities.login.constants.TOKENIZED_OTP;
import static com.example.network_activities.login.constants.URL;

import static com.example.network_activities.login.constants.USER_PROFILE;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;

import com.example.androidtraining_tasks.databinding.OtpScreenBinding;


import com.example.network_activities.mvvm_login.model.UserProfileModel;
import com.example.network_activities.mvvm_login.model.ValidateOTP;
import com.example.network_activities.mvvm_login.view_model.OTPViewModel;

public class OTPScreen extends AppCompatActivity {

    OtpScreenBinding binding;
    OTPViewModel viewModel;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OtpScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(OTPViewModel.class);

        binding.setMobileNumber(getIntent().getStringExtra(MOBILE_NO));

        binding.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.pinView.getText().toString().isEmpty()) {
                    // Handle empty OTP case
                    return;
                }

                viewModel.validateOTP(validateOTP(), URL, OTPScreen.this);
            }
        });

        viewModel.getUserProfile().observe(this, new Observer<UserProfileModel>() {
            @Override
            public void onChanged(UserProfileModel userProfile) {
                saveUserProfile(userProfile);
                navigationToUserProfileScreen(userProfile);
            }
        });
    }


    private void navigationToUserProfileScreen(UserProfileModel userProfile) {
        Intent intent = new Intent(OTPScreen.this, UserProfile.class);
        intent.putExtra(USER_PROFILE, userProfile);
        startActivity(intent);
    }

    private void saveUserProfile(UserProfileModel userProfile) {
        SharedPreferencesManager sharedPref = SharedPreferencesManager.getInstance(OTPScreen.this);
        sharedPref.saveUserProfile(userProfile);
    }

    public ValidateOTP validateOTP() {

        ValidateOTP validateOTP = new ValidateOTP();
        validateOTP.mobileNo = getIntent().getStringExtra(MOBILE_NO);
        validateOTP.otp = binding.pinView.getText().toString();
        validateOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        validateOTP.tokenizedOtp = getIntent().getStringExtra(TOKENIZED_OTP);
        return validateOTP;

    }


}

