package uk.co.entelect.design.patterns.strategy;

import java.util.List;
import java.util.function.Predicate;

/**
 * Implement the skeleton, inject the difference
 * <p>
 * Strategies are often a single method or function.
 * So, functional interfaces and lambdas work really well
 */
public class Sample {

    public static int total(
            List<Integer> numbers,
            Predicate<Integer> selector
    ) {

        return numbers.stream()
                      .filter(selector)
                      .mapToInt(e -> e)
                      .sum();
    }

    public static int sum(
            List<Integer> numbers,
            Predicate<Integer> selector
    ) {
        int total = 0;

        for (var number : numbers) {
            if (selector.test(number)) {
                total += number;
            }
        }

        return total;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(sum(numbers, ignore -> true));
        System.out.println(total(
                numbers,
                number -> number % 2 == 0
        ));

        System.out.println(sum(numbers, Sample::isOdd));
    }
}
