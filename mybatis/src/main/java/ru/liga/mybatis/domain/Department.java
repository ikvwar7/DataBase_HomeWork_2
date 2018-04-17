package ru.liga.mybatis.domain;

public class Department {
    private final Long id;
    private final String title;
    private final String address;
    private final Integer foundationYear;

    public Department(Long id, String title, String address, Integer foundationYear) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.foundationYear = foundationYear;
    }

    public Long id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String address() {
        return address;
    }

    public Integer foundationYear() {
        return foundationYear;
    }
}
