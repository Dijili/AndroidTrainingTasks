package com.example.network_activities.mvvm_login.view_model;

import android.content.Context;
import android.provider.Settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.network_activities.mvvm_login.model.RequestOTP;
import com.example.network_activities.mvvm_login.model.RequestOTPResponse;
import com.example.network_activities.mvvm_login.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileLoginViewModel extends ViewModel {

    private MutableLiveData<String> tokenizedOTPLiveData = new MutableLiveData<>();

    public LiveData<String> getTokenizedOTP() {
        return tokenizedOTPLiveData;
    }

    public void sendOTP(RequestOTP requestOTP, String url, Context context) {

        RetrofitClient.getInstance(context, url).getRetrofitAPI().sendAdminOTP(requestOTP)
                .enqueue(new Callback<RequestOTPResponse>() {
                    @Override
                    public void onResponse(Call<RequestOTPResponse> call, Response<RequestOTPResponse> response) {

                        if (response.isSuccessful() && response.code() == 200) {
                            tokenizedOTPLiveData.setValue(response.body().tokenizedOTP);
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestOTPResponse> call, Throwable t) {

                    }
                });
    }
}
