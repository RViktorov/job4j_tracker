package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

class PrinterTest {

    private static final ActionDelegate STUB_ACTION = () -> { };

    @Test
    public void whenPrintMenuThenOutputWithIndent() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Задача Общая", STUB_ACTION);
        menu.add("Задача Общая", "Задача Первая", STUB_ACTION);
        menu.add("Задача Первая", "Цель задачи", STUB_ACTION);
        menu.add("Задача Первая", "Ограничения и требования к решению", STUB_ACTION);
        menu.add("Задача Общая", "Задача Вторая", STUB_ACTION);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));

        try {
            new Printer().print(menu);
        } finally {
            System.setOut(stdout);
        }

        String ln = System.lineSeparator();
        String expected = String.join(ln,
                "1.Задача Общая",
                "----1.1.Задача Первая",
                "--------1.1.1.Цель задачи",
                "--------1.1.2.Ограничения и требования к решению",
                "----1.2.Задача Вторая"
        ) + ln;

        assertThat(out.toString(StandardCharsets.UTF_8)).isEqualTo(expected);
    }

}