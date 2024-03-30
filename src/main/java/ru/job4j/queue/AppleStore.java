package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int numberCustomer = 0;
        String name = null;
        for (Customer lastCustomer : queue) {
            if (numberCustomer == count - 1) {
                name = lastCustomer.name();
                queue.poll();
                break;
            } else {
                queue.poll();
                numberCustomer++;
            }
        }
        return name;
    }

    public String getFirstUpsetCustomer() {
        String name = null;
        getLastHappyCustomer();
        for (Customer lastCustomer : queue) {
            name = lastCustomer.name();
            break;
        }
        return name;
    }
}