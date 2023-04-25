package uk.co.entelect.design.patterns.execute.around.method.arm;

/**
 * 4. ARM (Automatic Resource Management)
 * 'try with resources'
 * Easy to forget (Not compiler enforced)
 */
class Resource implements AutoCloseable {
    public Resource() {
        System.out.println("created...");
    }

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
        //ARM—Automatic Resource Management

        try (Resource resource = new Resource()) {
            resource.op1();
            resource.op2();
        }
    }
}
