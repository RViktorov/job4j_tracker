package ru.job4j.ood.srp.task.report;

import ru.job4j.ood.srp.task.formatter.DateTimeParser;
import ru.job4j.ood.srp.task.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.task.model.Employee;
import ru.job4j.ood.srp.task.model.EmployeeXml;
import ru.job4j.ood.srp.task.model.EmployeesWrapper;
import ru.job4j.ood.srp.task.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {
        private final Store store;
        private final DateTimeParser<Calendar> parser;
        private final JAXBContext context;

        public XmlReportEngine(Store store) {
            this.store = store;
            this.parser = new ReportDateTimeParser();

            try {
                this.context = JAXBContext.newInstance(EmployeesWrapper.class);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String generate(Predicate<Employee> filter) {
            List<EmployeeXml> list = new ArrayList<>();
            for (Employee e : store.findBy(filter)) {
                list.add(new EmployeeXml(
                        e.getName(),
                        parser.parse(e.getHired()),
                        parser.parse(e.getFired()),
                        e.getSalary()
                ));
            }

            try {
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                String xml;
                try (StringWriter writer = new StringWriter()) {
                    marshaller.marshal(new EmployeesWrapper(list), writer);
                    xml = writer.getBuffer().toString();
                }
                return xml;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
}