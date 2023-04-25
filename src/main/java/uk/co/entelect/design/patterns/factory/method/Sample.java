package uk.co.entelect.design.patterns.factory.method;
/*
Factory Method
Intent
Define an interface for creating an object, but let subclasses decide which class to
instantiate. Factory Method lets a class defer instantiation to subclasses.
 */


interface Pet {}

interface Person {
    Pet getPet();

    default void play() {
        System.out.println("playing with " + getPet());
    }
}

class Dog implements Pet {}

class Cat implements Pet {}

class DogPerson implements Person {
    private final Dog dog = new Dog();

    public Pet getPet() {
        return dog;
    }
}

class CatLover implements Person {
    private final Cat cat = new Cat();

    public Pet getPet() {
        return cat;
    }
}

public class Sample {
    public static void call(Person person) {
        person.play();
    }

    public static void main(String[] args) {
        call(new DogPerson());
        call(new CatLover());
    }
}
