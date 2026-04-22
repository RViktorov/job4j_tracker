package ru.job4j.ood.isp.menu;

import java.util.Optional;
import java.util.Scanner;

/**
 * 6. Создайте простенький класс TodoApp. Этот класс будет представлять собой консольное приложение, которое позволяет:
 * Добавить элемент в корень меню;
 * Добавить элемент к родительскому элементу;
 * Вызвать действие, привязанное к пункту меню (действие можно сделать константой,
 * например, ActionDelete DEFAULT_ACTION = () -> System.out.println("Some action") и указывать при добавлении элемента в меню);
 * Вывести меню в консоль.
 */
public class TodoApp {
    private static final ActionDelegate DEFAULT_ACTION =
            () -> System.out.println("Some action");

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new Printer();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println();
            System.out.println("1. Добавить пункт в корень");
            System.out.println("2. Добавить подпункт");
            System.out.println("3. Выполнить действие пункта");
            System.out.println("4. Показать меню");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            String select = scanner.nextLine();

            switch (select) {
                case "1":
                    System.out.print("Введите имя пункта: ");
                    String rootName = scanner.nextLine();
                    boolean addedRoot = menu.add(Menu.ROOT, rootName, DEFAULT_ACTION);
                    System.out.println(addedRoot ? "Пункт добавлен" : "Ошибка добавления");
                    break;
                case "2":
                    System.out.print("Введите имя родителя: ");
                    String parent = scanner.nextLine();
                    System.out.print("Введите имя подпункта: ");
                    String child = scanner.nextLine();
                    boolean addedChild = menu.add(parent, child, DEFAULT_ACTION);
                    System.out.println(addedChild ? "Подпункт добавлен" : "Родитель не найден");
                    break;
                case "3":
                    System.out.print("Введите имя пункта: ");
                    String itemName = scanner.nextLine();
                    Optional<Menu.MenuItemInfo> item = menu.select(itemName);
                    if (item.isPresent()) {
                        item.get().getActionDelegate().delegate();
                    } else {
                        System.out.println("Пункт не найден");
                    }
                    break;
                case "4":
                    printer.print(menu);
                    break;
                case "0":
                    run = false;
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }

}