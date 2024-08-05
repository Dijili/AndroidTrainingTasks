package com.example.network_activities;

import static com.example.network_activities.login.constants.MOBILE_NO;
import static com.example.network_activities.login.constants.TOKENIZED_OTP;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.network_activities.login.APIInterface;
import com.example.network_activities.login.model.ValidateOTP;
import com.example.androidtraining_tasks.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OtpActivity_Json extends AppCompatActivity {

    private EditText pin_view;

    Button save_button;
    String mobileNo = " ";
    String tokenizedOtp;
    String entered_pin = " ";

    UserProfileModel data;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_screen);

        pin_view = (EditText) findViewById(R.id.pin_view);
        save_button = findViewById(R.id.done_btn);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String entered_pin = pin_view.getText().toString();

                ValidateOTP validateOTP = new ValidateOTP();
                validateOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

                validateOTP.tokenizedOtp = getIntent().getStringExtra(TOKENIZED_OTP);
                validateOTP.mobileNo = getIntent().getStringExtra(MOBILE_NO);
                validateOTP.otp = entered_pin;
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(logging);


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://htadminserviceapi-dev.azurewebsites.net/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();

                APIInterface retrofitAPI = retrofit.create(APIInterface.class);
//                Call<JsonObject> call = retrofitAPI.validateOTP(validateOTP);
//                call.enqueue(new Callback<JsonObject>() {
//                    @Override
//                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//
//
//                        JsonObject user_info = response.body().get("UserProfile").getAsJsonObject();
//
//                        String user_ID = user_info.get("UserID").getAsString();
//                        String first_name = user_info.get("FirstName").getAsString();
//                        String last_name = user_info.get("LastName").getAsString();
//                        String mobile_no = user_info.get("MobileNumber").getAsString();
//
//                        data = new UserProfileModel();
//
//                        Intent intent = new Intent(OtpActivity_Json.this, UserProfile.class);
//                        intent.putExtra(DETAILS, data);
//                        startActivity(intent);
//                    }
//
//
//                    @Override
//                    public void onFailure(Call<JsonObject> call, Throwable t) {
//                    }
//                });

            }
        });

    }
}
