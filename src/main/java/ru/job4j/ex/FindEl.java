package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
            } else {
                throw new ElementNotFoundException("the specified element is not in the array");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"ivan", "petr", "semen"};
        try {
            indexOf(array, "roman");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}