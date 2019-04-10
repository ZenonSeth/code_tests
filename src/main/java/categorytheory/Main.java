package categorytheory;

import java.util.function.Function;

class Main {
    interface Functor1<T> {
        <R> Functor1<R> map(Function<T, R> f);
    }

    interface Functor<T, F extends Functor<?, ?>> {
        <R> F map(Function<T, R> f);
    }

    static class Identity<T> implements Functor<T, Identity<?>> {
        private final T value;

        Identity(T value) {
            this.value = value;
        }

        public <R> Identity<R> map(Function<T, R> f) {
            final R result = f.apply(value);
            return new Identity<>(result);
        }
    }

}