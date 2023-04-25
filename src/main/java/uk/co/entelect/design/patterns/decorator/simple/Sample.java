package uk.co.entelect.design.patterns.decorator.simple;

import java.util.function.Function;

/**
 * Decorator Pattern
 * <p>
 * Dynamically add functionality
 * <p>
 * Functions are composable.
 * <pre>
 * value    --->    |inc|       ---->   result
 * value    --->    |doubled|   ---->   result
 * </pre>
 * <p>
 * combined
 * <pre>
 * value    ---->   |inc|   --->    |doubled|   ---->   result
 * </pre>
 */
public class Sample {
    public static void print(
            int number,
            String message,
            Function<Integer, Integer> func
    ) {

        System.out.println(number + " " +
                                   message + ": " + func.apply(number));
    }

    public static void main(String[] args) {
        Function<Integer, Integer> inc = value -> value + 1;
        Function<Integer, Integer> doubled = value -> value * 2;

        print(5, "incremented", inc);
        print(5, "doubled", doubled);

        print(5, "incremented and doubled",
              inc.andThen(doubled)
        );
    }
}
