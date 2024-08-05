package com.example.student_information_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;

public class StudentProfileActivity extends AppCompatActivity {

    ArrayList<StudentInfo> students = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_listview);
        ListView listview = findViewById(R.id.listView);
        setStudentProfile();
        StudentProfileAdapter listviewAdapter = new StudentProfileAdapter(this, students);
        listview.setAdapter(listviewAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentInfo studentInfo = (StudentInfo) parent.getItemAtPosition(position);
                Intent intent = new Intent(StudentProfileActivity.this, StudentInfoActivity.class);
                intent.putExtra("student", studentInfo);
                startActivity(intent);

            }
        });
    }

    private void setStudentProfile() {

        StudentInfo madhuri = new StudentInfo();
        madhuri.studentName = "Madhuri";
        madhuri.studentID = 101;
        madhuri.student_profile = R.drawable.student_light_skin_tone_svgrepo_com;
        students.add(madhuri);

        StudentInfo laya = new StudentInfo();
        laya.studentName = "Laya";
        laya.studentID = 102;
        laya.student_profile = R.drawable.student_light_skin_tone_svgrepo_com;
        students.add(laya);

        StudentInfo madhumitha = new StudentInfo();
        madhumitha.studentName = "MadhuMitha";
        madhumitha.studentID = 103;
        madhumitha.student_profile = R.drawable.student_light_skin_tone_svgrepo_com;
        students.add(madhumitha);

        StudentInfo mounika = new StudentInfo();
        mounika.studentName = "Mounika";
        mounika.studentID = 104;
        mounika.student_profile = R.drawable.student_light_skin_tone_svgrepo_com;
        students.add(mounika);

        StudentInfo ramya = new StudentInfo();
        ramya.studentName = "Ramya";
        ramya.studentID = 105;
        ramya.student_profile = R.drawable.student_light_skin_tone_svgrepo_com;
        students.add(ramya);

    }

}
