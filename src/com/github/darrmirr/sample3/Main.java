package com.github.darrmirr.sample3;

import com.github.darrmirr.sample2.PeekLog;

/**
 * Sample 3 :
 *     log message after function is executed
 */
public interface Main {

    static void main(String[] args) {
        var peekLog = PeekLog.of(System.getLogger("main"));

        var calcPipeline = Operation
                .plusAndLog(3)
                .andThen(Operation.minusAndLog(10))
                .andThen(Operation.multiplyAndLog(3))
                .andThen(Operation.plus(6));

        calcPipeline
                .andThen(peekLog.info("execution result : {0}"))
                .apply(5);
    }
}
