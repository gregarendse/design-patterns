package uk.co.entelect.design.patterns.execute.around.method.verbose;

/**
 * 3. Easy to forget & verbose
 * Code is verbose
 * User has to use try-catch-finally
 */
class Resource {
    public Resource() {System.out.println("created...");}

    public Resource op1() {
        System.out.println("op1...");
        return this;
    }

    public Resource op2() {
        System.out.println("op2...");
        return this;
    }

    public void close() {
        System.out.println("release external resource");
    }
}

public class Sample {
    public static void main(String[] args) {
        Resource resource = new Resource();
        try {
            resource.op1();
            resource.op2();
        } finally {
            resource.close();
        }
    }
}
