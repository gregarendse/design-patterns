package uk.co.entelect.design.patterns.execute.around.method.finalize;

/**
 * 1. Problem to clean up
 * Finalize not called.
 * Has been deprecated since Java 9
 */
class Resource {
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

    @Override
    protected void finalize() {  //has since been deprecated
        System.out.println("release external resource");
    }
}

public class Sample {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.op1();
        resource.op2();
        //finalize not called
    }
}
