package com.github.darrmirr.sample0;

import java.util.function.Function;

/**
 * Operation interface contains simple arithmetic functions
 */
public interface Operation {

    static Function<Integer, Integer> plus(Integer b) {
        return a -> a + b;
    }

    static Function<Integer, Integer> minus(Integer b) {
        return a -> a - b;
    }

    static Function<Integer, Integer> multiply(Integer b) {
        return a -> a * b;
    }
}
