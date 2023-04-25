package uk.co.entelect.design.patterns.decorator.combined;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Decorator Pattern
 * <p>
 * Dynamically add functionality
 */
class Camera {
    private final Function<Color, Color> filter;

    /**
     * Dynamically add filters a camera
     *
     * @param filters
     */
    public Camera(Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                       .reduce(Function.identity(), Function::andThen);
    }

    public Color snap(Color input) {
        return filter.apply(input);
    }
}

public class Sample {
    public static void print(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        print(new Camera());

        print(new Camera(Color::brighter));
        print(new Camera(Color::darker));

        print(new Camera(Color::brighter, Color::darker));
    }
}
