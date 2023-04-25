package uk.co.entelect.design.patterns.lazy;

import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class Lazy<T> {
    private T value;

    private final Supplier<T> supplier;

    public T getValue() {
        if (this.value == null) {
            this.value = this.supplier.get();
        }
        return this.value;
    }
}
