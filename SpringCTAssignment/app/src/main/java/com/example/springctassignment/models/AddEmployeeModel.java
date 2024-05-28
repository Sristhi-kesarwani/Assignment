package com.example.springctassignment.models;

public class AddEmployeeModel {
    String EmpName;
    int age;
    String Address;

    public AddEmployeeModel(String empName, int age, String address) {

        EmpName = empName;
        this.age = age;
        Address = address;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
