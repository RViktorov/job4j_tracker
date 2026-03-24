package ru.job4j.ood.srp.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesWrapper {

    @XmlElement(name = "employee")
    private List<EmployeeXml> employees;

    public EmployeesWrapper() {
    }

    public EmployeesWrapper(List<EmployeeXml> employees) {
        this.employees = employees;
    }

}