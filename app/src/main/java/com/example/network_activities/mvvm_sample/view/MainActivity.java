package com.example.network_activities.mvvm_sample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;

import com.example.androidtraining_tasks.databinding.MvvmLayoutMainBinding;
import com.example.network_activities.mvvm_sample.view_model.AppViewModel;

public class MainActivity extends AppCompatActivity {

    MvvmLayoutMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The ViewModel  will update the Model
        // after observing the changes in the View
        binding = MvvmLayoutMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(new AppViewModel());
        binding.executePendingBindings();
    }


    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
