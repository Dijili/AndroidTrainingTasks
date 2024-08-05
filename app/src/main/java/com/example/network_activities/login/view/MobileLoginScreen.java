package com.example.network_activities.login.view;

import static com.example.network_activities.login.constants.APPLICATION_ID;
import static com.example.network_activities.login.constants.MOBILE_NO;
import static com.example.network_activities.login.constants.STRING;
import static com.example.network_activities.login.constants.TOKENIZED_OTP;
import static com.example.network_activities.login.constants.URL;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.databinding.HononowLoginscreenBinding;
import com.example.network_activities.login.controller.MobileLoginController;
import com.example.network_activities.login.model.RequestOTP;

public class MobileLoginScreen extends AppCompatActivity implements MobileLoginController.MobileLoginCallback {

    HononowLoginscreenBinding binding;
    String tokenizedOTP;

    MobileLoginController controller;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HononowLoginscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        controller = new MobileLoginController(this, this);
        binding.sendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBar.setVisibility(View.VISIBLE);
                controller.sendOTP(requestOTP(), URL);
            }
        });
    }



    public RequestOTP requestOTP() {
        RequestOTP requestOTP = new RequestOTP();
        requestOTP.mobileNo = binding.mobilenumberEdittxt.getText().toString();
        requestOTP.secretKey = STRING;
        requestOTP.applicationID = APPLICATION_ID;
        requestOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        requestOTP.isResend = false;
        return requestOTP;
    }

    @Override
    public void OTPSent(String tokenizedOTP) {
        binding.progressBar.setVisibility(View.GONE);
        this.tokenizedOTP = tokenizedOTP;
        navigationToOTPScreen();
    }


    public void navigationToOTPScreen() {
        Intent intent = new Intent(MobileLoginScreen.this, OTPScreen.class);
        intent.putExtra(TOKENIZED_OTP, tokenizedOTP);
        intent.putExtra(MOBILE_NO, binding.mobilenumberEdittxt.getText().toString());
        startActivity(intent);
    }

}
