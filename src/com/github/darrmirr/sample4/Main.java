package com.github.darrmirr.sample4;

import static java.lang.System.Logger.Level.*;

/**
 * Sample 4 :
 *     wrap function by logable one
 */
public interface Main {

    static void main(String[] args) {
        var calcPipeline = Operation
                .plus(3)
                .logAfter("Result : {0}").logBefore("Input : {0}")
                .andThen(Operation
                        .minus(10)
                        .logAfter("Result : {0}"))
                .andThen(Operation
                        .multiply(3)
                        .logAfter(WARNING, "Warn log output for value : {0}"))
                .andThen(Operation.plus(6));

        calcPipeline = LogableFunction
                .of(calcPipeline)
                .logBefore("Start calculation")
                .logAfter("Finish calculation with value : {0}");

        calcPipeline.apply(5);
    }
}
