package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> result = Optional.empty();
        for (Student student : students.keySet()) {
            if (student.account().equals(account)) {
                result = Optional.of(student);
            }
        }
        return result;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        Optional<Subject> subject = Optional.empty();
        if (student.isPresent()) {
            for (Subject sub : students.get(student.get())) {
                if (sub.name().equals(name)) {
                    subject = Optional.of(sub);
                }
            }
        }
        return subject;
    }
}