package com.example.androidtraining_tasks.constraintlayout;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.databinding.ClinicprofileCardBinding;
import com.example.androidtraining_tasks.databinding.ClinicprofileFragmentBinding;


import java.util.ArrayList;

public class ClinicProfileAdapter extends RecyclerView.Adapter<ClinicProfileAdapter.ViewHolder> {

    private ArrayList<ClinicProfileModel> clinic_details;

    private ClinicProfileFragment clinicProfileFragment;

    public ClinicProfileAdapter(ArrayList<ClinicProfileModel> clinic_details, ClinicProfileFragment clinicProfileFragment) {

        this.clinic_details = clinic_details;
        this.clinicProfileFragment = clinicProfileFragment;
    }

    @NonNull
    @Override
    public ClinicProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(clinicProfileFragment.getContext());
        ClinicprofileCardBinding binding = ClinicprofileCardBinding.inflate(inflater, parent, false);
        return new ClinicProfileAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClinicProfileAdapter.ViewHolder holder, int position) {
        ClinicProfileModel details = clinic_details.get(position);
        holder.bind(details);
    }

    @Override
    public int getItemCount() {
        return clinic_details.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ClinicprofileCardBinding binding;

        public ViewHolder(@NonNull ClinicprofileCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(ClinicProfileModel details) {
            binding.image.setImageResource(details.getImage());
            binding.peopleCare.setText(details.getClinic_center());
            binding.madhapur.setText(details.getLocation());
            binding.mobileNum.setText(details.getMobile_num());
            binding.yes.setText(details.getConfirmation());
            binding.address.setText(details.getAddress());


        }
    }

}
