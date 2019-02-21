package com.infoshare.test.validation;

public class Validate {

    static void notNull(Object o) {
        if (o == null) {
            throw new ValidationException("Provided value should not be null.");
        }
    }

    static void inclusiveBetween(int start, int end, int value) {
        if (value < start || value > end) {
            throw new ValidationException(
                    String.format("The value %s is not in the specified inclusive range of %s to %s", value, start, end));
        }
    }

    static void inclusiveBetween(long start, long end, long value) {
        if (value < start || value > end) {
            throw new ValidationException(
                    String.format("The value %s is not in the specified inclusive range of %s to %s", value, start, end));
        }
    }

    static void notBlank(String string) {
        if(string == null) {
            throw new ValidationException("Provided string is null.");
        }
        if(string.isBlank()) {
            throw new ValidationException("Provided string is blank.");
        }
    }

    static void isTrue(boolean value, String message) {
        if(value) {
            throw new ValidationException(message);
        }
    }

    static void isFalse(boolean value, String message) {
        isTrue(!value, message);
    }

}