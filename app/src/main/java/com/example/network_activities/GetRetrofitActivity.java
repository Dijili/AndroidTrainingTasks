package com.example.network_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.network_activities.login.APIInterface;
import com.example.androidtraining_tasks.R;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofitActivity extends AppCompatActivity {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://reqres.in/";
    private Button btnGetData;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getdata_retrofit);
        btnGetData = findViewById(R.id.btnGetData);
        listView = findViewById(R.id.listviewData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Methods methods = getRetrofitInstance().create(Methods.class);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://reqres.in/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APIInterface retrofitAPI = retrofit.create(APIInterface.class);
                Call<Modal> call = retrofitAPI.getAllData();
                call.enqueue(new Callback<Modal>() {
                    @Override
                    public void onResponse(Call<Modal> call, Response<Modal> response) {
                        ArrayList<Modal.data> data = response.body().getData();
                        String[] names = new String[data.size()];
                        for (int i = 0; i < data.size(); i++) {
                            names[i] = "Id : " + data.get(i).getId() + "\nName : " + data.get(i).getFirst_name() + " " + data.get(i).getLast_name() + "\nEmail : " + data.get(i).getEmail();
                        }
                        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, names));
                    }

                    @Override
                    public void onFailure(Call<Modal> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}



