package com.github.darrmirr.sample1;

import static java.lang.System.Logger.Level.*;

/**
 * Sample 1:
 *     log message at lambda body
 */
public interface Main {
    System.Logger logger = System.getLogger("main");

    static void main(String[] args) {
        var calcPipeline = Operation
                .plus(3)
                .andThen(Operation.minus(10))
                .andThen(Operation.multiply(3))
                .andThen(Operation.plus(6));

        logger.log(INFO, "execution result : " + calcPipeline.apply(5));
    }
}
