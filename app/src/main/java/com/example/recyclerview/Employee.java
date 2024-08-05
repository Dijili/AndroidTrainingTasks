package com.example.recyclerview;

public class Employee {

    public String employeeName;

    private int employeeRollNo;

    private int image;


    public Employee(String employeeName, int employeeRollNo, int image) {
        this.employeeName = employeeName;
        this.employeeRollNo = employeeRollNo;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmployeeName() {
        return employeeName;
    }


    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeRollNo() {
        return employeeRollNo;
    }

    public void setEmployeeRollNo(int employeeRollNo) {
        this.employeeRollNo = employeeRollNo;
    }
}
