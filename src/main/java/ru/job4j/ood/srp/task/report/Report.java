package ru.job4j.ood.srp.task.report;

import ru.job4j.ood.srp.task.model.Employee;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);

}