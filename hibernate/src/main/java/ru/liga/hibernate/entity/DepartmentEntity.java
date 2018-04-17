package ru.liga.hibernate.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department",  uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "TITLE")})
public class DepartmentEntity implements Serializable {
    @Id
   // @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;

    @Column(name = "ADDRESS", unique = false, nullable = false)
    private String address;

    @Column(name = "FOUNDATION_YEAR", unique = false, nullable = false)
    private Integer foundationYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeEntity> employees;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "department", cascade=CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
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

    public Integer  getFoundationYear() {
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
