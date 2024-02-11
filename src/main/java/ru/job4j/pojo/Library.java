package ru.job4j.pojo;

import java.util.Arrays;
import java.util.Objects;

public class Library {

    public static void main(String[] args) {
        Book[] array = new Book[4];
        Book temp;
        Book book = new Book("Clean code", 100);
        Book book1 = new Book("Kolobok", 5);
        Book book2 = new Book("Head First Java", 300);
        Book book3 = new Book("SQL book", 100);
        array[0] = book;
        array[1] = book1;
        array[2] = book2;
        array[3] = book3;

        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index].getNameBook() + " " + array[index].getNumberPages());
        }
        temp = array[0];
        array[0] = array[3];
        array[3] = temp;

        for (int index = 0; index < array.length; index++) {
            if (Objects.equals(array[index].getNameBook(), "Clean code")) {
                System.out.println(array[index].getNameBook() + " " + array[index].getNumberPages());
            }
        }
    }
}