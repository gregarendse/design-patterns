package uk.co.entelect.design.patterns.lazy;

public class Sample {
    public static int compute(int number) {
        //imagine takes some time to compute
        System.out.println("compute called...");
        return number * 100;
    }

    private static void eagerEvaluation(final int value) {

        final int temp = compute(value);    //  compute is evaluated, but never used

        if (value > 4 && temp > 100) {
            System.out.println("path 1 with " + temp);
        } else {
            System.out.println("path 2");
        }
    }

    private static void lazyEvaluation(final int value) {
        final Lazy<Integer> temp = new Lazy<>(() -> compute(value));    //  compute is not evaluated until it is needed

        if (value > 4 && temp.getValue() > 100) {
            System.out.println("path 1 with " + temp.getValue());
        } else {
            System.out.println("path 2");
        }
    }

    public static void main(String[] args) {
        int value = 4;

        eagerEvaluation(value);

        lazyEvaluation(value);

    }
}

/*
David Wheeler: 
In computer science we can solve almost any problem by introducing
one more level of indirection

In procedural code, pointers given the power of indirection
In Object Orientated code, overriding functions given the power of indirection
In Functional Programing, lambdas give the power of indirection


  myFunction1(Type value) - eager
  myFunction2(Supplier<Type> supplier) - lazy

  When do we pass value vs. a functional interface to
  a method?

  One consideration is lazy evaluation
*/
