package ru.job4j.ood.srp.task.report;

import ru.job4j.ood.srp.task.formatter.DateTimeParser;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ProgrammerReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> parser;

    public ProgrammerReport(Store store, DateTimeParser<Calendar> parser) {
        this.store = store;
        this.parser = parser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator());

        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(",")
                    .append(parser.parse(employee.getHired())).append(",")
                    .append(parser.parse(employee.getFired())).append(",")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}