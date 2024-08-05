package com.example.androidtraining_tasks;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView firstname, lastname, email, phonenumber, address, city, state, zipcode, country, dateofbirth, age, occupation, gender, maritalStatus;
    FormModel object;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_data);
        //Hooks
        firstname = findViewById(R.id.firstname_info);
        lastname = findViewById(R.id.lastname_info);
        email = findViewById(R.id.email_info);
        phonenumber = findViewById(R.id.phonenumber_info);
        address = findViewById(R.id.address_info);
        city = findViewById(R.id.city_info);
        state = findViewById(R.id.state_info);
        zipcode = findViewById(R.id.zipcode_info);
        country = findViewById(R.id.country_info);
        dateofbirth = findViewById(R.id.dob_info);
        age = findViewById(R.id.age_info);
        occupation = findViewById(R.id.occupation_info);
        gender = findViewById(R.id.gender_info);
        maritalStatus = findViewById(R.id.maritalstatus_info);

        //Get text from intent
        object = (FormModel) getIntent().getSerializableExtra("formModel");

        //Set Text
        firstname.setText(object.getFirstName());
        lastname.setText(object.getLastName());
        email.setText(object.getEmail());
        phonenumber.setText(object.getPhoneNumber());
        address.setText(object.getAddress());
        city.setText(object.getCity());
        state.setText(object.getState());
        zipcode.setText(object.getZipCode());
        country.setText(object.getCountry());
        dateofbirth.setText(object.getDateOfBirth());
        age.setText(object.getAge());
        occupation.setText(object.getOccupation());
        gender.setText(object.getGender());
        maritalStatus.setText((object.getMaritalStatus()));

    }
}
