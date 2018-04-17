package ru.liga.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class EmployeeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column(name = "fio", unique = false, nullable = false)
    private String fio;
    @Column(name = "gender", unique = false, nullable = false)
    private String gender;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department_id", nullable = false)
    private DepartmentEntity department;
    @Column(name = "degree", unique = false, nullable = false)
    private String degree;
    @Column(name = "position", unique = false, nullable = false)
    private String position;
    @Column(name = "birthday", unique = false, nullable = false)
    private LocalDate  birthday;

    public EmployeeEntity(Long id, String fio, String gender, DepartmentEntity department, String degree, String position, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department = department;
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

    public DepartmentEntity getDepartment() {
        return department;
    }

    public String getDegree() {
        return degree;
    }

    public String getPosition() {
        return position;
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

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
