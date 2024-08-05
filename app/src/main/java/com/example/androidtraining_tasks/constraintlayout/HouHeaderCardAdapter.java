package com.example.androidtraining_tasks.constraintlayout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.HouHeadercardItemsBinding;
import com.example.androidtraining_tasks.databinding.ItemLabSampleDetailsBinding;
import com.example.recyclerview.Employee;
import com.example.recyclerview.EmployeeRecyclerViewAdapter;

import java.util.ArrayList;

public class HouHeaderCardAdapter extends RecyclerView.Adapter<HouHeaderCardAdapter.ViewHolder> {

    private ArrayList<HouHeaderCardData> card_details;

    private HouMainActivity houMainActivity;
    private OnItemClickListener listener; // Listener object

    private Activity activity;

//        private SummaryMainActivity summaryMainActivity;

//    private UserManagementActivity userManagementActivity;

    public HouHeaderCardAdapter(ArrayList<HouHeaderCardData> card_details, Activity activity) {
        this.card_details = card_details;
        this.activity = activity;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public HouHeaderCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        HouHeadercardItemsBinding binding = HouHeadercardItemsBinding.inflate(inflater, parent, false);
        return new HouHeaderCardAdapter.ViewHolder(binding);
    }



    @Override
    public void onBindViewHolder(@NonNull HouHeaderCardAdapter.ViewHolder holder, int position) {


        HouHeaderCardData details = card_details.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
        holder.bind(details);
    }

    @Override
    public int getItemCount() {
        return card_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private HouHeadercardItemsBinding binding;

        public ViewHolder(@NonNull HouHeadercardItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HouHeaderCardData details) {
            binding.image.setImageResource(details.getImage());
            binding.name.setText(details.getName());

        }
    }
}
