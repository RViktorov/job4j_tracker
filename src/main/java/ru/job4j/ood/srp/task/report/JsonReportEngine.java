package ru.job4j.ood.srp.task.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.task.formatter.DateTimeParser;
import ru.job4j.ood.srp.task.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.model.EmployeeJson;
import ru.job4j.ood.srp.task.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {
    private final Store store;
    private final Gson gson;
    private final DateTimeParser<Calendar> parser;

    public JsonReportEngine(Store store) {
        this.store = store;
        this.parser = new ReportDateTimeParser();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        List<Employee> employees = store.findBy(filter);
        List<EmployeeJson> list = new ArrayList<>();

        for (Employee e : employees) {
            EmployeeJson json = new EmployeeJson(
                    e.getName(),
                    parser.parse(e.getHired()),
                    parser.parse(e.getFired()),
                    e.getSalary()
            );
            list.add(json);
        }
        return gson.toJson(list);
    }

}