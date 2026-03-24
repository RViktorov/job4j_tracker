package ru.job4j.ood.srp.task.model;

public class EmployeeJson {
    private String name;
    private String hired;
    private String fired;
    private double salary;

    public EmployeeJson(String name, String hired, String fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getHired() {
        return hired;
    }

    public String getFired() {
        return fired;
    }

    public double getSalary() {
        return salary;
    }
}

