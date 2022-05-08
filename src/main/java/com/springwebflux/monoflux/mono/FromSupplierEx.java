package com.springwebflux.monoflux.mono;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class FromSupplierEx {

    public static void main(String[] args) {
//        Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = FromSupplierEx::getName;
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(ConsumerUtil.onNext());

        Callable<String> stringCallable = FromSupplierEx::getName;
        Mono.fromCallable(stringCallable).subscribe(ConsumerUtil.onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return ConsumerUtil.faker().name().fullName();
    }
}
