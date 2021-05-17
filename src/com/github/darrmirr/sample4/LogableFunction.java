package com.github.darrmirr.sample4;

import java.util.function.Function;

/**
 * Function put any java.util.function.Function to logable context
 *
 * @param <T> function's input object class
 * @param <R> function's output object class
 */
@FunctionalInterface
public interface LogableFunction<T, R> extends Function<T, R> {

    /**
     * Put input function to logable context
     *
     * @param function to enrich new log features
     * @param <T> function's input object class
     * @param <R> function's output object class
     * @return input function with log features
     */
    static <T, R> LogableFunction<T, R> of(Function<T, R> function) {
        return function::apply;
    }

    /**
     * Put input function to logable context and set user defined logger
     *
     * @param function o enrich new log features
     * @param logger user defined logger
     * @param <T> function's input object class
     * @param <R> function's output object class
     * @return input function with log features where is used user defined logger
     */
    static <T, R> LogableFunction<T, R> of(Function<T, R> function, System.Logger logger) {
        return new LogableFunction<T, R>() {
            @Override
            public R apply(T t) {
                return function.apply(t);
            }

            @Override
            public PeekLog logger() {
                return PeekLog.of(logger);
            }
        };
    }

    /**
     * Get function that is used to log messages
     *
     * @return PeekLog function
     */
    default PeekLog logger() {
        return PeekLog.of(System.getLogger("main"));
    }

    /**
     * Log message after function execution at INFO log level
     *
     * @param message message to log
     * @return new function that is created as composition current one and logging one
     */
    default LogableFunction<T, R> logAfter(String message) {
        return this.andThen(logger().info(message))::apply;
    }

    /**
     * Log message before function execution at INFO log level
     *
     * @param message message to log
     * @return new function that is created as composition current one and logging one
     */
    default LogableFunction<T, R> logBefore(String message) {
        return this.compose(logger().info(message))::apply;
    }

    /**
     * Log message after function execution at user defined log level
     *
     * @param level user defined log level
     * @param message message to log
     * @return new function that is created as composition current one and logging one
     */
    default LogableFunction<T, R> logAfter(System.Logger.Level level, String message) {
        return this.andThen(logger().log(level, message))::apply;
    }

    /**
     * Log message before function execution at user defined log level
     *
     * @param level user defined log level
     * @param message message to log
     * @return new function that is created as composition current one and logging one
     */
    default LogableFunction<T, R> logBefore(System.Logger.Level level, String message) {
        return this.compose(logger().log(level, message))::apply;
    }
}
