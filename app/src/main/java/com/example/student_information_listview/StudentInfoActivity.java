package com.example.student_information_listview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.R;

public class StudentInfoActivity extends AppCompatActivity {

    TextView studentname, rollno;
    StudentInfo studentInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentinfo_txtview);
        //label Id's
        studentname = findViewById(R.id.label_studentname_info);
        rollno = findViewById(R.id.rollno_info);

        //Get text from intent
        studentInfo = (StudentInfo) getIntent().getSerializableExtra("student");

        //SetText
        studentname.setText(studentInfo.getStudentName());
        rollno.setText(String.valueOf(studentInfo.getStudentID()));
    }
}
