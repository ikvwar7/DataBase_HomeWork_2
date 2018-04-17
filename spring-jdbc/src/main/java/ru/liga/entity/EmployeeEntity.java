package ru.liga.entity;

import java.time.LocalDate;

public class EmployeeEntity {
    private String id;
    private String fio;
    private String gender;
    private String department;
    private String degree;
    private String position;
    private LocalDate birthday;

    public EmployeeEntity(String id, String fio, String gender, String faculty, String degree, String position, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department = faculty;
        this.degree = degree;
        this.position = position;
        this.birthday = birthday;
    }

    public EmployeeEntity() {
    }

    public String getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getDegree() {
        return degree;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
