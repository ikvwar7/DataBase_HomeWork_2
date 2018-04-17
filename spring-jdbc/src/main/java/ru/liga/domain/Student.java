package ru.liga.domain;

public class Student {
    private final String id;
    private final String fio;
    private final String gender;
    private final String faculty;
    private final String studentGroupId;
    private final String birthday;


    public Student(String id, String fio, String gender, String faculty, String studentGroupId, String birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.faculty = faculty;
        this.studentGroupId = studentGroupId;
        this.birthday = birthday;
    }
}
