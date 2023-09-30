package com.spring.example.rest.exception_handling;

public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData(){
    }
    public String getInfo(){
        return this.info;
    }

    public void setInfo(String info){
        this.info = info;
    }
}
