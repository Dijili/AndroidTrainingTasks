package com.example.network_activities.login;



import com.example.network_activities.DataModal;
import com.example.network_activities.Modal;
import com.example.network_activities.login.model.RequestOTP;
import com.example.network_activities.login.model.RequestOTPResponse;
import com.example.network_activities.login.model.ValidateOTP;
import com.example.network_activities.login.model.ValidateOtpResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("users")
        //on below line we are creating a method to post our data.
    Call<DataModal> createPost(@Body DataModal dataModal);

    @GET("api/users?page=1")
    Call<Modal> getAllData();

    @POST("SendExecutiveOTP")
    Call<RequestOTPResponse> sendAdminOTP(@Body RequestOTP requestOTP);

    @POST("ValidateAdminOTP")
    Call<ValidateOtpResponse> validateOTP(@Body ValidateOTP validateOTP);




}
