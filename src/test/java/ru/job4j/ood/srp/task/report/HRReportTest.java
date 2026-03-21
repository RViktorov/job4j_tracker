package ru.job4j.ood.srp.task.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.store.MemoryStore;
import ru.job4j.ood.srp.task.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class HRReportTest {
    @Test
    public void whenSortedSalaryDesc() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee low = new Employee("Low", now, now, 100);
        Employee high = new Employee("High", now, now, 200);
        store.add(low);
        store.add(high);

        Report report = new HRReport(store);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(high.getName()).append(";")
                .append(high.getSalary())
                .append(System.lineSeparator())
                .append(low.getName()).append(";")
                .append(low.getSalary())
                .append(System.lineSeparator());

        assertThat(report.generate(emp -> true)).isEqualTo(expected.toString());
    }

}