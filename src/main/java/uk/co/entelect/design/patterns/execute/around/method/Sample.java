package uk.co.entelect.design.patterns.execute.around.method;

import java.util.function.Consumer;

/**
 * 6. Execute Around Method
 * <p>
 * "Civilized AOP"
 * <p>
 * Enforce safe usage
 * Caller can only use methods in a safe manner. The resources will always be released.
 * <p>
 * e.g.
 * <pre>{@code
 *     Transaction.runInTransaction(tx -> ...);
 * }</pre>
 */
class Resource {
    private Resource() {
        System.out.println("created...");
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource(); //before

        try {
            block.accept(resource);
        } finally {
            resource.close(); //after
        }
    }

    public Resource op1() {
        System.out.println("op1...");
        return this;
    }

    public Resource op2() {
        System.out.println("op2...");
        return this;
    }

    private void close() {
        System.out.println("release extenal resource");
    }
}

public class Sample {
    public static void main(String[] args) {
        Resource.use((Resource resource) -> {
            resource.op1()
                    .op2();
        });
    }
}
