package com.example.student_information_listview;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentInfo implements Serializable {

    public int studentID;
    public int student_profile;
    public String studentName;

    public StudentInfo() {
    }

    public String studentrollno;

    public String getStudentrollno() {
        return studentrollno;
    }

    public void setStudentrollno(String studentrollno) {
        this.studentrollno = studentrollno;
    }

    public ArrayList<String> studentInfo;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudent_profile() {
        return student_profile;
    }

    public void setStudent_profile(int student_profile) {
        this.student_profile = student_profile;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<String> getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(ArrayList<String> studentInfo) {
        this.studentInfo = studentInfo;
    }


}
