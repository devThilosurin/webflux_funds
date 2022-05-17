package com.springwebflux.monoflux.batching;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class WindowEx {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        eventStream()
//                .window(5)
                .window(Duration.ofSeconds(2))
                .flatMap(WindowEx::saveEvents)
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event " + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux) {
        return flux
                .doOnNext(e -> System.out.println("Saving " + e))
                .doOnComplete(() -> {
                    System.out.println("Saved this batch...");
                    System.out.println("-------------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}
