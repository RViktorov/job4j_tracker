package ru.job4j.queue;

import java.util.*;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    public String getEvenElements() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; evenElements.size() > 0; i++) {
            if (i % 2 == 0) {
                result.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return String.valueOf(result);
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        while (descendingElements.size() > 0) {
            result.append(descendingElements.pollLast());
        }
        return String.valueOf(result);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}