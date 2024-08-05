package com.example.androidtraining_tasks;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button save_button, male_button, female_button, other_button, single_button, married_button, divorced_button;
    Toast toast;
    EditText firstname_edit, lastname_edit, email_edit, phonenumber_edit, address_edit, city_edit, state_edit, zipcode_edit, age_edit;
    TextView dateofbirth_edit, tc_text;
    Spinner country_spinner, occupation_spinner;
    FormModel object;
    String gender = "";
    String maritalStatus = "";
    CheckBox chkTerms;
    String tc = "";
    String privacypolicy = "";

    boolean isAllFieldsChecked = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_registration);


        //hooks called for toasts
        firstname_edit = findViewById(R.id.firstname_edit);
        lastname_edit = findViewById(R.id.lastname_edit);
        email_edit = findViewById(R.id.email_edit);
        phonenumber_edit = findViewById(R.id.phonenumber_edit);
        address_edit = findViewById(R.id.address_edit);
        city_edit = findViewById(R.id.city_edit);
        state_edit = findViewById(R.id.state_edit);
        country_spinner = findViewById(R.id.country_dd);
        occupation_spinner = findViewById(R.id.occupation_dd);
        zipcode_edit = findViewById(R.id.zipcode_edit);
        dateofbirth_edit = findViewById(R.id.dob_edit);
        age_edit = findViewById(R.id.age_edit);
        save_button = findViewById(R.id.save_button);
        male_button = findViewById(R.id.male_button);
        female_button = findViewById(R.id.female_button);
        other_button = findViewById(R.id.other_button);
        single_button = findViewById(R.id.single_button);
        married_button = findViewById(R.id.married_button);
        divorced_button = findViewById(R.id.divorced_button);
        ImageView imageView = (ImageView) findViewById(R.id.userprofile_image);
        chkTerms = findViewById(R.id.checkbox);
        tc_text = findViewById(R.id.tc_text);


        SpannableString string = new SpannableString("Accept terms & conditions and privacy policy");
        setSpan(string, string.toString().indexOf("terms"), string.toString().lastIndexOf("and"));
        setSpan(string, string.toString().indexOf("privacy"), string.length());
        tc_text.setText(string);
        tc_text.setMovementMethod(LinkMovementMethod.getInstance());

        save_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (chkTerms.isChecked()) {
                    isAllFieldsChecked = CheckAllFields();
                    //Get data from input field
                    String firstName = firstname_edit.getText().toString();
                    String lastName = lastname_edit.getText().toString();
                    String email = email_edit.getText().toString();
                    String phoneNumber = phonenumber_edit.getText().toString();
                    String address = address_edit.getText().toString();
                    String city = city_edit.getText().toString();
                    String state = state_edit.getText().toString();
                    String zipCode = zipcode_edit.getText().toString();
                    String country_chosenOption = country_spinner.getSelectedItem().toString();
                    String occupation_chosenOption = occupation_spinner.getSelectedItem().toString();
                    String dateOfBirth = dateofbirth_edit.getText().toString();
                    String age = age_edit.getText().toString();

                    object = new FormModel();

                    object.setFirstName(firstName);
                    object.setLastName(lastName);
                    object.setEmail(email);
                    object.setPhoneNumber(phoneNumber);
                    object.setAddress(address);
                    object.setCity(city);
                    object.setState(state);
                    object.setZipCode(zipCode);
                    object.setCountry(country_chosenOption);
                    object.setDateOfBirth(dateOfBirth);
                    object.setAge(age);
                    object.setOccupation(occupation_chosenOption);
                    object.setGender(gender);
                    object.setMaritalStatus(maritalStatus);
                    //Pass data to 2nd activity
                    if (isAllFieldsChecked) {

                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("formModel", object);
                        startActivity(intent);
                    }
                }
            }


        });

        dateofbirth_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                dateofbirth_edit.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                age_edit.setText("" + calculateAge(year, monthOfYear, dayOfMonth));
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        // Set onClickListeners for gender buttons
        male_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Male";
                selectGenderButton(male_button);
            }
        });

        female_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Female";
                selectGenderButton(female_button);
            }
        });

        other_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Other";
                selectGenderButton(other_button);
            }
        });


        // Set onClickListeners for marital status buttons
        single_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maritalStatus = "Single";
                selectMaritalStatusButton(single_button);
            }
        });

        married_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maritalStatus = "Married";
                selectMaritalStatusButton(married_button);
            }
        });

        divorced_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maritalStatus = "Divorced";
                selectMaritalStatusButton(divorced_button);
            }
        });


    }


    private SpannableString setSpan(SpannableString string, int startIndex, int endIndex) {
        string.setSpan(new UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new ForegroundColorSpan(Color.BLUE), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return string;
    }


    private int calculateAge(int year, int monthOfYear, int dayOfMonth) {
        Calendar dobCalendar = Calendar.getInstance();
        dobCalendar.set(year, monthOfYear, dayOfMonth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);
//        age_edit.setText(String.valueOf(age));
        return age;
    }

    private void selectGenderButton(Button selectedButton) {
        male_button.setSelected(selectedButton == male_button);
        female_button.setSelected(selectedButton == female_button);
        other_button.setSelected(selectedButton == other_button);
    }

    private void selectMaritalStatusButton(Button selectedButton) {
        single_button.setSelected(selectedButton == single_button);
        married_button.setSelected(selectedButton == married_button);
        divorced_button.setSelected(selectedButton == divorced_button);
    }

    private boolean CheckAllFields() {

        if (firstname_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter First Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lastname_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Last Name", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (email_edit.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher("email_edit").matches()) {
//            Toast.makeText(getApplicationContext(), "Email Verified !", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "Enter valid Email address !", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        if (email_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email_edit.getText().toString()).matches()) {
            Toast.makeText(getApplicationContext(), "Enter valid Email address!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (phonenumber_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Phone Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (address_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (city_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter City", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (state_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter State", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (zipcode_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Zip Code", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (country_spinner.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Country", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (dateofbirth_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Date of Birth", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (age_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Age", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (occupation_spinner.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Occupation", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(getApplicationContext(), "Patient details are saved", Toast.LENGTH_SHORT).show();
        return true;
    }


}

