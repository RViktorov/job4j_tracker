package ru.job4j.ood.srp.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXml {

    private String name;
    private String hired;
    private String fired;
    private double salary;

    public EmployeeXml() {
    }

    public EmployeeXml(String name, String hired, String fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

}