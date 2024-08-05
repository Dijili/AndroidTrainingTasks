package com.example.androidtraining_tasks.constraintlayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.PatientdataCardviewBinding;
import com.example.androidtraining_tasks.databinding.TestdetailsCardBinding;

import java.util.ArrayList;

public class PatientVitalsAdapter extends RecyclerView.Adapter<PatientVitalsAdapter.ViewHolder> {

    private ArrayList<PatientVitalsData> patient_vitals;
    private PatientVitalsActivity patientVitalsActivity;

    public PatientVitalsAdapter(ArrayList<PatientVitalsData> patient_vitals, PatientVitalsActivity patientVitalsActivity) {
        this.patient_vitals = patient_vitals;
        this.patientVitalsActivity = patientVitalsActivity;
    }

    @NonNull
    @Override
    public PatientVitalsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(patientVitalsActivity);
        PatientdataCardviewBinding binding = PatientdataCardviewBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientVitalsAdapter.ViewHolder holder, int position) {
        PatientVitalsData vitals = patient_vitals.get(position);
        holder.bind(vitals);


    }

    @Override
    public int getItemCount() {
        return patient_vitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private PatientdataCardviewBinding binding;

        TextView token_name, token_opid, token_gender, token_age;


        public ViewHolder(@NonNull PatientdataCardviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
//            token_name = itemView.findViewById(R.id.user_name);
//            token_opid = itemView.findViewById(R.id.opid);
//            token_gender = itemView.findViewById(R.id.gender);
//            token_age = itemView.findViewById(R.id.age);
        }

        public void bind(PatientVitalsData vitals) {
            binding.userName.setText(vitals.getName());
            binding.opid.setText(vitals.getOpid());
            binding.gender.setText(vitals.getGender());
            binding.age.setText(vitals.getAge());

        }
    }
}
