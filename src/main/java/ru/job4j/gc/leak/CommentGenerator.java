package ru.job4j.gc.leak;

import ru.job4j.gc.leak.models.Comment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {

    public static final String PATH_PHRASES = "files/phrases.txt";
    public static final String SEPARATOR = System.lineSeparator();
    public static final int COUNT = 50;

    private static List<String> phrases;
    private final UserGenerator userGenerator;
    private final Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        try {
            phrases = read(PATH_PHRASES);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void generate() {
    }

    public List<Comment> generateComments() {
        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < COUNT; i++) {

            String text = new StringBuilder()
                    .append(phrases.get(random.nextInt(phrases.size())))
                    .append(SEPARATOR)
                    .append(phrases.get(random.nextInt(phrases.size())))
                    .append(SEPARATOR)
                    .append(phrases.get(random.nextInt(phrases.size())))
                    .toString();

            Comment comment = new Comment();
            comment.setText(text);
            comment.setUser(userGenerator.randomUser());
            comments.add(comment);
        }

        return comments;
    }

}