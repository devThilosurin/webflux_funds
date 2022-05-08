package com.springwebflux.monoflux.mono;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;

public class SubscribeEx {
    public static void main(String[] args) {

        Mono<Integer> mono = Mono
                .just("boom")
                .map(String::length);

//        mono.subscribe(System.out::println);

        /*
        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed!")
        );
         */

        mono.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );
    }
}
