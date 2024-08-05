package com.example.recyclerview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> strings;
    private Activity activity;
    private ArrayList<Integer> images;


    // data is passed into the constructor
    RecyclerViewAdapter(ArrayList<String> strings, Activity activity, ArrayList<Integer> images) {
        this.strings = strings;
        this.activity = activity;
        this.images = images;
    }


    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.recyclerview_countries_txtview, parent, false));
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView.setText(strings.get(position));
        holder.imageView.setImageResource(images.get(position));

    }

    // convenience method for getting data at click position
    String getItem(int position) {
        return strings.get(position);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return strings.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.countries_txtview);
            imageView = itemView.findViewById(R.id.student_image);

        }
    }
}





