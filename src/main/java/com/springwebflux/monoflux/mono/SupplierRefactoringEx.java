package com.springwebflux.monoflux.mono;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SupplierRefactoringEx {

    public static void main(String[] args) {
        getName();
//        getName()
//                .subscribeOn(Schedulers.boundedElastic())
//                .subscribe(ConsumerUtil.onNext());
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName();

        ConsumerUtil.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            ConsumerUtil.sleepSeconds(3);
            return ConsumerUtil.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
