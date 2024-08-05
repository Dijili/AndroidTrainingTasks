package com.example.androidtraining_tasks.constraintlayout;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.databinding.HouClinicFormBinding;
import com.example.androidtraining_tasks.databinding.ItemLabSampleDetailsBinding;
import com.example.androidtraining_tasks.databinding.OutpatientsCardBinding;

import java.util.ArrayList;

public class HouClinicAdapter extends RecyclerView.Adapter<HouClinicAdapter.ViewHolder> {

    private ArrayList<HouClinicData> lab_details;
    private HouClinicActivity houClinicActivity;


    public HouClinicAdapter(ArrayList<HouClinicData> lab_details, HouClinicActivity houClinicActivity) {
        this.lab_details = lab_details;
        this.houClinicActivity = houClinicActivity;
    }

    @NonNull
    @Override
    public HouClinicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(houClinicActivity);
        ItemLabSampleDetailsBinding binding = ItemLabSampleDetailsBinding.inflate(inflater, parent, false);
        return new HouClinicAdapter.ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull HouClinicAdapter.ViewHolder holder, int position) {
        HouClinicData details = lab_details.get(position);
        holder.bind(details);
    }


    @Override
    public int getItemCount() {
        return lab_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemLabSampleDetailsBinding binding;

        public ViewHolder(@NonNull ItemLabSampleDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HouClinicData details) {
            binding.checkbox.setText(details.getLabtest_name());
            binding.completed.setText(details.getStatus());
        }
    }


}
