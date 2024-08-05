package com.example.network_activities.mvvm_login.view;

import static com.example.network_activities.login.constants.APPLICATION_ID;
import static com.example.network_activities.login.constants.MOBILE_NO;
import static com.example.network_activities.login.constants.STRING;
import static com.example.network_activities.login.constants.TOKENIZED_OTP;
import static com.example.network_activities.login.constants.URL;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidtraining_tasks.databinding.HononowLoginscreenBinding;


import com.example.network_activities.mvvm_login.model.RequestOTP;
import com.example.network_activities.mvvm_login.view_model.MobileLoginViewModel;

public class MobileLoginScreen extends AppCompatActivity {


    HononowLoginscreenBinding binding;
    MobileLoginViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HononowLoginscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MobileLoginViewModel.class);

        binding.sendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.mobilenumberEdittxt.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }
                viewModel.sendOTP(requestOTP(), URL, MobileLoginScreen.this);
            }
        });



        viewModel.getTokenizedOTP().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String tokenizedOTP) {
                navigationToOTPScreen(tokenizedOTP);
            }
        });
    }

    private void navigationToOTPScreen(String tokenizedOtp) {
        Intent intent = new Intent(MobileLoginScreen.this, OTPScreen.class);
        intent.putExtra(TOKENIZED_OTP, tokenizedOtp);
        intent.putExtra(MOBILE_NO, binding.mobilenumberEdittxt.getText().toString());
        startActivity(intent);

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

}
