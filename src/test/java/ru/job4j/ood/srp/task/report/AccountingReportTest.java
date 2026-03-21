package ru.job4j.ood.srp.task.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.task.currency.Currency;
import ru.job4j.ood.srp.task.currency.CurrencyConverter;
import ru.job4j.ood.srp.task.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.task.formatter.DateTimeParser;
import ru.job4j.ood.srp.task.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.store.MemoryStore;
import ru.job4j.ood.srp.task.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class AccountingReportTest {
    @Test
    public void whenGenerateAccountingReportInUSD() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();

        Report report = new AccountingReport(store, parser, converter, Currency.USD);

        double converted = converter.convert(Currency.RUB, worker.getSalary(), Currency.USD);

        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary in USD;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(converted)
                .append(System.lineSeparator());

        assertThat(report.generate(emp -> true)).isEqualTo(expected.toString());
    }

}