package ru.job4j.search1;

import ru.job4j.search1.Person;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> findInName = person -> person.getName().contains(key);
        Predicate<Person> findInSurname = person -> person.getSurname().contains(key);
        Predicate<Person> findInPhone = person -> person.getPhone().contains(key);
        Predicate<Person> findInAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = findInName.or(findInSurname).or(findInPhone).or(findInAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}