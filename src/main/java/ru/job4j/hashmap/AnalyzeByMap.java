package ru.job4j.hashmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
                count++;
            }
        }
        return result / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double result = 0;
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
            }
            labels.add(new Label(pupil.name(), result / pupil.subjects().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> res = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function = (oldScore, newScore) -> oldScore + newScore;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                res.merge(subject.name(), subject.score(), function);
            }
        }

        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            if (pupils.size() > 0) {
                labels.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
            } else {
                labels.add(new Label(entry.getKey(), entry.getValue()));
            }
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int allScore = 0;
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
            }
            labels.add(new Label(pupil.name(), allScore));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> res = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function = (oldScore, newScore) -> oldScore + newScore;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!res.containsKey(subject.name())) {
                    res.put(subject.name(), subject.score());
                } else {
                    res.merge(subject.name(), subject.score(), function);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }
}