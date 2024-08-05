package com.example.network_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.network_activities.login.APIInterface;
import com.example.androidtraining_tasks.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRetrofitActivity extends AppCompatActivity {

    private EditText nameEdt, emailEdt;
    private Button save_btn;
    private TextView response_data;
    private ProgressBar progress_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postdata_retrofit);

        // initializing our views
        nameEdt = findViewById(R.id.name);
        emailEdt = findViewById(R.id.email);
        save_btn = findViewById(R.id.save_btn);
        response_data = findViewById(R.id.response_data);
        progress_bar = findViewById(R.id.progress_bar);

        // adding on click listener to our button.
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (nameEdt.getText().toString().isEmpty() && emailEdt.getText().toString().isEmpty()) {
                    Toast.makeText(PostRetrofitActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(nameEdt.getText().toString(), emailEdt.getText().toString());
            }
        });
    }


    private void postData(String name, String email) {

        progress_bar.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // below line is to create an instance for our retrofit api class.
        APIInterface retrofitAPI = retrofit.create(APIInterface.class);

        DataModal modal = new DataModal(name, email);

        Call<DataModal> call = retrofitAPI.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {

                Toast.makeText(PostRetrofitActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                progress_bar.setVisibility(View.GONE);
                emailEdt.setText("");
                nameEdt.setText("");
                DataModal responseFromAPI = response.body();
                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getEmail();
                response_data.setText(responseString);
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                response_data.setText("Error found is : " + t.getMessage());
            }
        });
    }
}
