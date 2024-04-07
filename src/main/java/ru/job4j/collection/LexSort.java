package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        List<String> leftArray = new ArrayList<>(List.of(left.split(". ")));
        List<String> rightArray = new ArrayList<>(List.of(right.split(". ")));
        return Integer.compare(Integer.parseInt(leftArray.get(0)), Integer.parseInt(rightArray.get(0)));
    }
}
