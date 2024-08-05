package com.example.cancel_appointment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.R;
import com.example.dialog_task.PaymentActivity;

public class CancelAppointmentActivity extends AppCompatActivity {
    TextView eligible_txtcontent;

    Button cancel_dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canceldialog_layout);
        cancel_dialog = findViewById(R.id.dialogBtn);
        Dialog dialog = new Dialog(this);
        cancel_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.cancel_appointment);

                eligible_txtcontent = dialog.findViewById(R.id.eligible_txtcontent);
                SpannableString string = new SpannableString("Eligible for Refund Amount Rs.500");
                string.setSpan(new ForegroundColorSpan(getColor(R.color.light_green)), string.toString().indexOf("Eligible"), string.toString().lastIndexOf("Rs"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                string.setSpan(new ForegroundColorSpan(getColor(R.color.dark_green)), string.toString().indexOf("Rs"), string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                eligible_txtcontent.setText(string);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });

    }


}
