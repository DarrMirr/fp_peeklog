package com.github.darrmirr.sample4;

import static java.lang.System.Logger.Level.INFO;

/**
 * Operation interface contains simple arithmetic functions
 *
 * Additional:
 *
 *     - Contains log statements at function's body
 *     - Extends LogableFunction interface
 */
@FunctionalInterface
public interface Operation extends LogableFunction<Integer, Integer> {
    PeekLog PEEK_LOG = PeekLog.of(System.getLogger("calc"));

    static Operation plus(Integer b) {
        return a ->  {
            PEEK_LOG.get().log(INFO, "operation : plus, a : {0}, b : {1}", a, b);
            return a + b;
        };
    }

    static Operation minus(Integer b) {
        return a -> {
            PEEK_LOG.get().log(INFO, "operation : minus, a : {0}, b : {1}", a, b);
            return a - b;
        };
    }

    static Operation multiply(Integer b) {
        return a -> {
            PEEK_LOG.get().log(INFO, "operation : multiply, a : {0}, b : {1}", a, b);
            return a * b;
        };
    }

    @Override
    default PeekLog logger() {
        return PEEK_LOG;
    }
}
