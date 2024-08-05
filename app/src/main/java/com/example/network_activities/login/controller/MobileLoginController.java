package com.example.network_activities.login.controller;

import android.content.Context;

import com.example.network_activities.login.model.RequestOTP;
import com.example.network_activities.login.model.RequestOTPResponse;
import com.example.network_activities.login.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileLoginController {


    private Context context;
    private MobileLoginCallback callback;

    public MobileLoginController(Context context, MobileLoginCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void sendOTP(RequestOTP requestOTP, String url) {
        RetrofitClient.getInstance(context, url).getRetrofitAPI().sendAdminOTP(requestOTP)
                .enqueue(new Callback<RequestOTPResponse>() {
                    @Override
                    public void onResponse(Call<RequestOTPResponse> call, Response<RequestOTPResponse> response) {
                        if (response.isSuccessful() && response.code() == 200) {
                            callback.OTPSent(response.body().tokenizedOTP);
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestOTPResponse> call, Throwable t) {

                    }
                });
    }


    public interface MobileLoginCallback {
        void OTPSent(String tokenizedOTP);
    }


}
