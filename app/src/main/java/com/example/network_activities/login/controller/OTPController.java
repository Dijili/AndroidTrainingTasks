package com.example.network_activities.login.controller;

import android.content.Context;

import com.example.network_activities.login.model.UserProfileModel;
import com.example.network_activities.login.model.ValidateOTP;
import com.example.network_activities.login.model.ValidateOtpResponse;
import com.example.network_activities.login.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OTPController {

    private Context context;
    private OTPCallback callback;

    public OTPController(Context context, OTPCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void validateOTP(ValidateOTP validateOTP, String url) {
        RetrofitClient.getInstance(context, url).getRetrofitAPI().validateOTP(validateOTP)
                .enqueue(new Callback<ValidateOtpResponse>() {
                    @Override
                    public void onResponse(Call<ValidateOtpResponse> call, Response<ValidateOtpResponse> response) {
                        if (response.isSuccessful() && response.code() == 200) {
                            callback.OTPValidated(response.body().userProfile);
                        }
                    }

                    @Override
                    public void onFailure(Call<ValidateOtpResponse> call, Throwable t) {

                    }
                });
    }


    public interface OTPCallback {
        void OTPValidated(UserProfileModel UserProfile);


    }


}
