package uk.co.entelect.design.patterns.fluency.allocation;

import java.util.function.Consumer;

class Mailer {
    public static void send(Consumer<Mailer> block) {
        var mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending...");
    }

    public Mailer from(String addr) {
        System.out.println("from...");
        return this;
    }

    public Mailer to(String addr) {
        System.out.println("to...");
        return this;
    }

    public Mailer subject(String line) {
        System.out.println("subject...");
        return this;
    }

    public Mailer body(String content) {
        System.out.println("body...");
        return this;
    }
}

public class Sample {
    public static void main(String[] args) {
        Mailer.send((Mailer mailer) -> mailer
                .from("builder@agiledeveloper.com")
                .to("venkats@agiledeveloper.com")
                .subject("Your code sucks")
                .body("...details...")
        );
    }
}
