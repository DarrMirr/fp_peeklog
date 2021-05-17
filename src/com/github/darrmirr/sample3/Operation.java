package com.github.darrmirr.sample3;

import java.util.function.Function;

/**
 * Operation interface contains simple arithmetic functions
 *
 * Additional:
 *
 *     - Contains log statements at function's body
 *     - Contains methods that combine simple arithmetic functions and input and output log function
 */
public interface Operation {
    PeekLog peekLog = PeekLog.of(System.getLogger("main"));

    static Function<Integer, Integer> plus(Integer b) {
        return a ->  {
            peekLog.get().log(System.Logger.Level.INFO, "operation : plus, a : {0}, b : {1}", a, b);
            return a + b;
        };
    }

    static Function<Integer, Integer> minus(Integer b) {
        return a -> {
            peekLog.get().log(System.Logger.Level.INFO, "operation : minus, a : {0}, b : {1}", a, b);
            return a - b;
        };
    }

    static Function<Integer, Integer> multiply(Integer b) {
        return a -> {
            peekLog.get().log(System.Logger.Level.INFO, "operation : multiply, a : {0}, b : {1}", a, b);
            return a * b;
        };
    }

    static Function<Integer, Integer> plusAndLog(Integer b) {
        return plus(b).andThen(peekLog.info("Result : {0}")).compose(peekLog.info("Input : {0}"));
    }

    static Function<Integer, Integer> minusAndLog(Integer b) {
        return minus(b).andThen(peekLog.info("Result : {0}"));
    }

    static Function<Integer, Integer> multiplyAndLog(Integer b) {
        return multiply(b).andThen(peekLog.info("Result : {0}"));
    }
}
