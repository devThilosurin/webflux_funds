package com.springwebflux.monoflux.sinks;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinkReplayEx {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("One");
        sink.tryEmitNext("Two");

        flux.subscribe(ConsumerUtil.subscriber("Bob"));
        flux.subscribe(ConsumerUtil.subscriber("Boom"));

        Mono.just("Three")
                .delayElement(Duration.ofSeconds(3))
                .doOnNext(sink::tryEmitNext)
                .subscribe();

        flux.subscribe(ConsumerUtil.subscriber("Boat"));
        sink.tryEmitNext("Four");

        ConsumerUtil.sleepSeconds(5);
    }
}
