package com.github.darrmirr.sample2;


/**
 * Sample 2 :
 *     log message after function is executed
 */
public interface Main {

    static void main(String[] args) {
        var peekLog = PeekLog.of(System.getLogger("main"));

        var calcPipeline = Operation
                .plus(3)
                .andThen(peekLog.info("Result : {0}")).compose(peekLog.info("Input : {0}"))
                .andThen(Operation
                        .minus(10)
                        .andThen(peekLog.info("Result : {0}")))
                .andThen(Operation
                        .multiply(3)
                        .andThen(peekLog.info("Result : {0}")))
                .andThen(Operation.plus(6));

        calcPipeline
                .andThen(peekLog.info("execution result : {0}"))
                .apply(5);
    }
}
