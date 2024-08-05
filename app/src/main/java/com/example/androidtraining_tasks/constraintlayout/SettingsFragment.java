package com.example.androidtraining_tasks.constraintlayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtraining_tasks.databinding.SettingsBinding;
import com.example.androidtraining_tasks.databinding.SummaryFragmentBinding;

import java.util.Calendar;

public class SettingsFragment extends Fragment {

    SettingsBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = SettingsBinding.inflate(getLayoutInflater());

        binding.startDateImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                calendar("startdate");
            }

        });

        binding.endDateImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                calendar("enddate");
            }

        });

        binding.timeIntervalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();


                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(requireActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                binding.timeIntervalImage.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);

                timePickerDialog.show();
            }
        });


        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void calendar(String date) {


        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        if (date.equals("startdate")) {
                            binding.startDateImage.setText(selectedDate);
                        } else {
                            binding.endDateImage.setText(selectedDate);
                        }
                    }
                },
                year, month, day
        );


        datePickerDialog.show();

    }

}
