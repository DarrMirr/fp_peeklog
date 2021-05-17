package com.github.darrmirr.sample2;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Function gets input value, pass it to logger as message parameter and return input value as input one
 */
@FunctionalInterface
public interface PeekLog extends Supplier<System.Logger> {

    /**
     * Create PeekLog function
     *
     * @param logger logger that is wrapped by PeekLog function
     * @return PeekLog function
     */
    static PeekLog of(System.Logger logger) {
        return () -> logger;
    }

    /**
     * Log message at INFO log level
     *
     * @param message message to log
     * @param <T> function's input and output object class
     * @return function with log capability
     */
    default <T> Function<T, T> info(String message) {
        return log(System.Logger.Level.INFO, message);
    }

    /**
     * Log message at user defined log level
     *
     * @param level user defined log level
     * @param message message to log
     * @param <T> function's input and output object class
     * @return function with log capability
     */
    default <T> Function<T, T> log(System.Logger.Level level, String message) {
        return t -> {
            this.get().log(level, message, t);
            return t;
        };
    }

}
