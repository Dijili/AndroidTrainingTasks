package com.example.androidtraining_tasks;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HealthServices extends AppCompatActivity {

    private EditText editText;
    private TextView charCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_services);

        editText = findViewById(R.id.editText);
        charCount = findViewById(R.id.charCount);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                charCount.setText(length + "/50");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
