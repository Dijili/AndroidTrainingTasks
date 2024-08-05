package com.example.network_activities.login.view;

import static com.example.network_activities.login.constants.MOBILE_NO;
import static com.example.network_activities.login.constants.TOKENIZED_OTP;
import static com.example.network_activities.login.constants.URL;
import static com.example.network_activities.login.constants.USERPROFILE_JSON;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.databinding.OtpScreenBinding;
import com.example.network_activities.login.controller.OTPController;
import com.example.network_activities.login.model.UserProfileModel;
import com.example.network_activities.login.model.ValidateOTP;

public class OTPScreen extends AppCompatActivity implements OTPController.OTPCallback {

    OtpScreenBinding binding;
    UserProfileModel UserProfile;
    OTPController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OtpScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        controller = new OTPController(this, this);
        binding.setMobileNumber(getIntent().getStringExtra(MOBILE_NO));
        binding.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.validateOTP(validateOTP(), URL);
            }
        });
    }



    public ValidateOTP validateOTP() {
        ValidateOTP validateOTP = new ValidateOTP();
        validateOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        validateOTP.tokenizedOtp = getIntent().getStringExtra(TOKENIZED_OTP);
        validateOTP.mobileNo = getIntent().getStringExtra(MOBILE_NO);
        validateOTP.otp = binding.pinView.getText().toString();
        return validateOTP;
    }


    @Override
    public void OTPValidated(UserProfileModel UserProfile) {
        this.UserProfile = UserProfile;
        saveUserProfile();
        navigateToUserProfileScreen();
    }

    public void navigateToUserProfileScreen() {
        Intent intent = new Intent(OTPScreen.this, UserProfile.class);
        intent.putExtra(USERPROFILE_JSON, UserProfile);
        startActivity(intent);
    }

    private void saveUserProfile() {
        SharedPreferencesManager sharedPref = SharedPreferencesManager.getInstance(OTPScreen.this);
        sharedPref.saveUserProfile(UserProfile);
    }

}

