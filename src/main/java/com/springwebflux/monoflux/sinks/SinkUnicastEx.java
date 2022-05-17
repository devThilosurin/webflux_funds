package com.springwebflux.monoflux.sinks;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinkUnicastEx {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(ConsumerUtil.subscriber("Bob"));
        flux.subscribe(ConsumerUtil.subscriber("Boom"));

        sink.tryEmitNext("One");
        sink.tryEmitNext("Two");

        Mono.just("Three")
                .delayElement(Duration.ofSeconds(3))
                .doOnNext(sink::tryEmitNext)
                .subscribe();
        ConsumerUtil.sleepSeconds(5);
    }
}
