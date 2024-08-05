package com.example.network_activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidtraining_tasks.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetActivity extends AppCompatActivity {

    private TextView get_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_layout);
        get_data = findViewById(R.id.get_data_txt);
        Button data = findViewById(R.id.get_data_btn);
        data.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getdata();
            }
        });
    }

    private void getdata() {
        String url = "https://reqres.in/api/users?id=7";
        new GetData().execute(url);
    }

    private class GetData extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0];
            String result = "";
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(urlString);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            get_data.setText(result);
        }
    }


}

