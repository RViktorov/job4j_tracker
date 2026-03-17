package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {
    @Test
    void ReturnNumberWhenNotFizzOrBuzz() {
        assertEquals("1", Fool.getFizzBuzz(1));
        assertEquals("2", Fool.getFizzBuzz(2));
        assertEquals("4", Fool.getFizzBuzz(4));
    }

    @Test
    void ReturnFizzWhenDivisibleByThree() {
        assertEquals("Fizz", Fool.getFizzBuzz(3));
        assertEquals("Fizz", Fool.getFizzBuzz(6));
        assertEquals("Fizz", Fool.getFizzBuzz(9));
    }

    @Test
    void ReturnBuzzWhenDivisibleByFive() {
        assertEquals("Buzz", Fool.getFizzBuzz(5));
        assertEquals("Buzz", Fool.getFizzBuzz(10));
    }

    @Test
    void ReturnFizzBuzzWhenDivisibleByThreeAndFive() {
        assertEquals("FizzBuzz", Fool.getFizzBuzz(15));
        assertEquals("FizzBuzz", Fool.getFizzBuzz(30));
    }

}