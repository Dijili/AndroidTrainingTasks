package com.example.student_information_listview;//package com.example.studentinformation_listview;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//
//public class StudentInfoAdapter extends BaseAdapter {
//    private StudentInfoActivity studentInfoActivity;
//    private List<String> students;
//
//    public StudentInfoAdapter(StudentInfoActivity studentInfoActivity, List<String> students) {
//        this.studentInfoActivity = studentInfoActivity;
//        this.students = students;
//    }
//
//    @Override
//    public int getCount() {
//        return students.size();
//    }
//
//    @Override
//    public String getItem(int position) {
//        return students.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(studentInfoActivity).inflate(R.layout.students_txtview, parent, false);
//        }
//        TextView studentFirstName = convertView.findViewById(R.id.firstname);
////        StudentInfo studentFirstName1 = getItem(position);
//        studentFirstName.setText(getItem(position));
////        studentFirstName.setText(studentFirstName1.getStudentName());
//
//        TextView studentEmail = convertView.findViewById(R.id.email);
//        studentEmail.setText(getItem(position));
////        studentEmail.setText(studentName1.getStudentemail());
//
//        TextView studentRollNo = convertView.findViewById(R.id.rollno);
//        studentRollNo.setText(getItem(position));
//
////        StudentInfo studentRollNo1 = getItem(position);
////        studentRollNo.setText(String.valueOf(studentRollNo1.getStudentrollno()));
//
//        ImageView image_view = convertView.findViewById(R.id.image_view);
//        image_view.setImageResource(Integer.parseInt(getItem(position)));
////        image_view.setImageResource(String.valueOf(getItem(position));
////        image_view.setImageResource(person.getStudent_profile());
//
//        return convertView;
//    }
//
//
//}
