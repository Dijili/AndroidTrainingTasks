package com.example.androidtraining_tasks.constraintlayout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.databinding.OutpatientsCardBinding;


import java.util.ArrayList;

public class OutPatientAdapter extends RecyclerView.Adapter<OutPatientAdapter.ViewHolder> {

    private ArrayList<OutPatientData> op_vitals;
    private OutPatientActivity outPatientActivity;

    public OutPatientAdapter(ArrayList<OutPatientData> op_vitals, OutPatientActivity outPatientActivity) {
        this.op_vitals = op_vitals;
        this.outPatientActivity = outPatientActivity;
    }

    @NonNull
    @Override
    public OutPatientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(outPatientActivity);
        OutpatientsCardBinding binding = OutpatientsCardBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OutPatientAdapter.ViewHolder holder, int position) {
        OutPatientData vitals = op_vitals.get(position);
        holder.bind(vitals);
    }

    @Override
    public int getItemCount() {
        return op_vitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private OutpatientsCardBinding binding;

        public ViewHolder(@NonNull OutpatientsCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(OutPatientData vitals) {
            binding.userName.setText(vitals.getName());
            binding.opid.setText(vitals.getOpid());
            binding.gender.setText(vitals.getGender());
            binding.age.setText(vitals.getAge());

        }
    }


}
