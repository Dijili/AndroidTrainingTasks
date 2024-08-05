package com.example.androidtraining_tasks.constraintlayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.TestdetailsCardBinding;

import java.util.ArrayList;

public class TestDetailsAdapter extends RecyclerView.Adapter<TestDetailsAdapter.ViewHolder> {

    private ArrayList<TestDetailsData> test_details;
    private TestDetailsActivity testDetailsActivity;

    public TestDetailsAdapter(ArrayList<TestDetailsData> test_details, TestDetailsActivity testDetailsActivity) {
        this.test_details = test_details;
        this.testDetailsActivity = testDetailsActivity;
    }

    @NonNull
    @Override
    public TestDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(testDetailsActivity);
        TestdetailsCardBinding binding = TestdetailsCardBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull TestDetailsAdapter.ViewHolder holder, int position) {
        TestDetailsData details = test_details.get(position);
        holder.bind(details);
    }

    @Override
    public int getItemCount() {
        return test_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TestdetailsCardBinding binding;

        public ViewHolder(@NonNull TestdetailsCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(TestDetailsData details) {
            binding.testName.setText(details.getTest_name());
            binding.code.setText(details.getCode());
            binding.sample.setText(details.getSample());
        }
    }
}
