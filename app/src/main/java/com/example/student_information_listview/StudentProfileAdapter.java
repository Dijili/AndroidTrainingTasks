package com.example.student_information_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtraining_tasks.R;

import java.util.List;

public class StudentProfileAdapter extends BaseAdapter {

    private StudentProfileActivity studentProfileActivity;
    private List<StudentInfo> students;

    public StudentProfileAdapter(StudentProfileActivity studentProfileActivity, List<StudentInfo> students) {
        this.studentProfileActivity = studentProfileActivity;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public StudentInfo getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(studentProfileActivity).inflate(R.layout.students_txtview, parent, false);
        }


        TextView studentName = convertView.findViewById(R.id.student_name);
        StudentInfo studentName1 = getItem(position);
        studentName.setText(studentName1.getStudentName());

        TextView studentID = convertView.findViewById(R.id.student_id);
        StudentInfo studentID1 = getItem(position);
        studentID.setText(String.valueOf(studentID1.getStudentID()));

        ImageView image_view = convertView.findViewById(R.id.image_view);
        StudentInfo person = getItem(position);
        image_view.setImageResource(person.getStudent_profile());

        return convertView;
    }


}
