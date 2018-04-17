package ru.liga.mybatis.entity;

import java.io.Serializable;
import java.util.List;

public class DepartmentEntity implements Serializable {
    private Long id;
    private String title;
    private String address;
    private Integer foundationYear;
    private List<EmployeeEntity> employees;
    private List<StudentEntity> students;

    public DepartmentEntity(Long id, String title, String address, Integer foundationYear, List<EmployeeEntity> employees, List<StudentEntity> students) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.foundationYear = foundationYear;
        this.employees = employees;
        this.students = students;
    }

    public DepartmentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
