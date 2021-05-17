package com.github.darrmirr.sample1;

import java.util.function.Function;

/**
 * Operation interface contains simple arithmetic functions
 *
 * Additional:
 *
 *     - Contains log statements at function's body
 */
public interface Operation {
    System.Logger LOGGER = System.getLogger("main");

    static Function<Integer, Integer> plus(Integer b) {
        return a ->  {
            LOGGER.log(System.Logger.Level.INFO, "operation : plus, a : {0}, b : {1}", a, b);
            return a + b;
        };
    }

    static Function<Integer, Integer> minus(Integer b) {
        return a -> {
            LOGGER.log(System.Logger.Level.INFO, "operation : minus, a : {0}, b : {1}", a, b);
            return a - b;
        };
    }

    static Function<Integer, Integer> multiply(Integer b) {
        return a -> {
            LOGGER.log(System.Logger.Level.INFO, "operation : multiply, a : {0}, b : {1}", a, b);
            return a * b;
        };
    }
}
