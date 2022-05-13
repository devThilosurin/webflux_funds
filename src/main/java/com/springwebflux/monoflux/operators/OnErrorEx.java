package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnErrorEx {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
//                .onErrorReturn(1)
//                .onErrorResume(e -> fallback())
                .onErrorContinue((err, obj) -> {

                })
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> ConsumerUtil.faker().random().nextInt(100, 200));
    }
}
