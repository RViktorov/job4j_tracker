package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class SuperGeneratorTest {

    @Test
    public void whenCorrectTemplateReplaceAllKeys() {
        Generator generator = new SuperGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );

        String result = generator.produce(template, args);
        assertThat(result).isEqualTo("I am a Petr Arsentev, Who are you?");
    }

    @Test
    public void whenMissingKeyInMap() {
        Generator generator = new SuperGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev"
        );

        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenExtraKeyInMap() {
        Generator generator = new SuperGenerator();
        String template = "I am a ${name}";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );

        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

}