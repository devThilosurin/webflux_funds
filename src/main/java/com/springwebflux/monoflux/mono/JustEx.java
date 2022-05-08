package com.springwebflux.monoflux.mono;

import reactor.core.publisher.Mono;

public class JustEx {
    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> System.out.println("Received : " + i));
    }
}
