package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.helper.PersonHelper;
import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.Function;

public class SwitchOnFirstEx {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst((signal, personHelperFlux) -> {
                    System.out.println("Inside Switch On First...");
                    int age = Objects.requireNonNull(signal.get()).getAge();

                    return (signal.isOnNext() && age > 30 && age < 50)
                            ? personHelperFlux
                            : applyFilterMap().apply(personHelperFlux);
                })
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<PersonHelper> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new PersonHelper());
    }

    public static Function<Flux<PersonHelper>, Flux<PersonHelper>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 30 && p.getAge() < 50)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(PersonHelper.class, p -> System.out.println("[Not Allowing] : " + p));
    }
}
