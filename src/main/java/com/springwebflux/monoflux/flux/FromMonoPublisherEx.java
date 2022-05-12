package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FromMonoPublisherEx {

    public static void main(String[] args) {
        /*
        Mono<String> mono = Mono.just("a");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(ConsumerUtil.onNext());
         */

        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next()
                .subscribe(
                        ConsumerUtil.onNext(),
                        ConsumerUtil.onError(),
                        ConsumerUtil.onComplete()
                );
    }

    private static void doSomething(Flux<String> flux) {

    }
}
