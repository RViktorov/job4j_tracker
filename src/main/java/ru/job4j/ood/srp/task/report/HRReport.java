package ru.job4j.ood.srp.task.report;

import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {
    private final Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}