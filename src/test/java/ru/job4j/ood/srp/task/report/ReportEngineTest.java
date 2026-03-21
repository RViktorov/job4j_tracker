package ru.job4j.ood.srp.task.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.task.formatter.DateTimeParser;
import ru.job4j.ood.srp.task.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.store.MemoryStore;
import ru.job4j.ood.srp.task.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportEngine(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
