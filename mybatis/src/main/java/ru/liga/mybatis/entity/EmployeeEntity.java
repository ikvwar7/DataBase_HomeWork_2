package ru.liga.mybatis.entity;

import java.time.LocalDate;

public class EmployeeEntity {
    private Long id;
    private String fio;
    private String gender;
    private Long departmentId;
    private String degree;
    private String position;
    private LocalDate birthday;

    public EmployeeEntity(Long id, String fio, String gender, Long departmentId, String degree, String position, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.departmentId = departmentId;
        this.degree = degree;
        this.position = position;
        this.birthday = birthday;
    }

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getGender() {
        return gender;
    }

    public Long getDepartmentId() {
        return departmentId;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
