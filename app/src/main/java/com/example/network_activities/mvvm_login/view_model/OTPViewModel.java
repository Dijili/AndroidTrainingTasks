package com.example.network_activities.mvvm_login.view_model;

import android.content.Context;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.network_activities.mvvm_login.model.UserProfileModel;
import com.example.network_activities.mvvm_login.model.ValidateOTP;
import com.example.network_activities.mvvm_login.model.ValidateOtpResponse;
import com.example.network_activities.mvvm_login.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPViewModel extends ViewModel {

    private MutableLiveData<UserProfileModel> userProfileLiveData = new MutableLiveData<>();


    public LiveData<UserProfileModel> getUserProfile() {
        return userProfileLiveData;
    }


    public void validateOTP(ValidateOTP validateOTP, String url, Context context) {


        RetrofitClient.getInstance(context, url).getRetrofitAPI().validateOTP(validateOTP)
                .enqueue(new Callback<ValidateOtpResponse>() {
                    @Override
                    public void onResponse(Call<ValidateOtpResponse> call, Response<ValidateOtpResponse> response) {
                        if (response.isSuccessful() && response.code() == 200) {
                            userProfileLiveData.setValue(response.body().userProfile);
                        }
                    }


                    @Override
                    public void onFailure(Call<ValidateOtpResponse> call, Throwable t) {

                    }
                });
    }

}
