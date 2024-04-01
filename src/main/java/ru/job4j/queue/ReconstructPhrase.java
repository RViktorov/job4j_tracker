package ru.job4j.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>(evenElements);
        for (int i = 0; i < list.size(); i += 2) {
            result.append(list.get(i));
        }
        return String.valueOf(result);
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>(descendingElements);
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i));
        }
        return String.valueOf(result);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}