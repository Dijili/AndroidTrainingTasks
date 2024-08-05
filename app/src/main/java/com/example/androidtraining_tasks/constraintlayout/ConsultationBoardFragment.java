package com.example.androidtraining_tasks.constraintlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtraining_tasks.R;
import com.example.androidtraining_tasks.databinding.ConsultationBinding;
import com.example.androidtraining_tasks.databinding.SummaryFragmentBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class ConsultationBoardFragment extends Fragment {

    ConsultationBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = ConsultationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 1; i <= 10; i++) {
            Chip chip = new Chip(requireActivity());
//            chip.setId(View.generateViewId());
            chip.setText("Room " + i);
            chip.setTextColor(getResources().getColor(R.color.grey));
            chip.setChipStrokeColorResource(R.color.grey);
            chip.setChipStrokeWidth(1);
            chip.setChipCornerRadius(0);
            chip.setTextSize(20);
            binding.chipGroup.addView(chip);
        }

        BottomSheetDialog bottom_dialog = new BottomSheetDialog(requireActivity());
        binding.addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_dialog.setContentView(R.layout.consultation_bottomsheet);
                ImageView cross;
                cross = bottom_dialog.findViewById(R.id.cross);

                cross.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottom_dialog.dismiss();
                    }
                });

                bottom_dialog.show();
            }
        });
    }
}
