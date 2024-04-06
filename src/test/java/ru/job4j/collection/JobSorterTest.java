package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobSorterTest {
    @Test
    void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Kix bug", 1),
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("Kix bug", 1),
                new Job("X task", 0));

        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Kix bug", 1),
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Kix bug", 1),
                new Job("Bix bug", 2),
                new Job("Aix bug", 4));
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Kix bug", 1),
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Kix bug", 1),
                new Job("Bix bug", 2),
                new Job("Aix bug", 4)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Kix bug", 1),
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("Kix bug", 1),
                new Job("X task", 0));
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByNameLengthDescByNameDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Kix bug", 1),
                new Job("Aix bug", 4),
                new Job("Bix bug", 2),
                new Job("X task", 0)
        );
        Comparator<Job> combine = new JobDescByNameLength()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
        Collections.sort(jobs, combine);
        List<Job> expected = Arrays.asList(
                new Job("Kix bug", 1),
                new Job("Bix bug", 2),
                new Job("Aix bug", 4),
                new Job("X task", 0));
        assertThat(jobs).isEqualTo(expected);
    }
}