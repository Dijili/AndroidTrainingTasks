package com.example.androidtraining_tasks.constraintlayout;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.databinding.HouHeadercardItemsBinding;
import com.example.androidtraining_tasks.databinding.UsermanagementFragmentBinding;

import java.util.ArrayList;

public class UserManagementAdapter extends RecyclerView.Adapter<UserManagementAdapter.ViewHolder> {

    private ArrayList<UserManagementModel> user_details;

    private UserManagementFragment userManagementFragment;

    public UserManagementAdapter(ArrayList<UserManagementModel> user_details, UserManagementFragment userManagementFragment) {
        this.user_details = user_details;
        this.userManagementFragment = userManagementFragment;
    }


    @NonNull
    @Override
    public UserManagementAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(userManagementFragment.getContext());
        UsermanagementFragmentBinding binding = UsermanagementFragmentBinding.inflate(inflater, parent, false);
        return new UserManagementAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserManagementAdapter.ViewHolder holder, int position) {
        UserManagementModel details = user_details.get(position);
        holder.bind(details);
    }


    @Override
    public int getItemCount() {
        return user_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private UsermanagementFragmentBinding binding;

        public ViewHolder(@NonNull UsermanagementFragmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UserManagementModel details) {

            binding.lohit.setText(details.getName());
            binding.physiotherapist.setText(details.getRole());


        }
    }

}
