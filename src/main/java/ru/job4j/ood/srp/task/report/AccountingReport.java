package ru.job4j.ood.srp.task.report;

import ru.job4j.ood.srp.task.currency.Currency;
import ru.job4j.ood.srp.task.currency.CurrencyConverter;
import ru.job4j.ood.srp.task.formatter.DateTimeParser;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class AccountingReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> parser;
    private final CurrencyConverter converter;
    private final Currency target;

    public AccountingReport(Store store,
                            DateTimeParser<Calendar> parser,
                            CurrencyConverter converter,
                            Currency target) {
        this.store = store;
        this.parser = parser;
        this.converter = converter;
        this.target = target;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary in ")
                .append(target)
                .append(";")
                .append(System.lineSeparator());

        for (Employee employee : store.findBy(filter)) {
            double converted = converter.convert(
                    Currency.RUB,
                    employee.getSalary(),
                    target
            );

            text.append(employee.getName()).append(";")
                    .append(parser.parse(employee.getHired())).append(";")
                    .append(parser.parse(employee.getFired())).append(";")
                    .append(converted)
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}