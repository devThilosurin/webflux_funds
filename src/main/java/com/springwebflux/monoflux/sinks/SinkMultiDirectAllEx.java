package com.springwebflux.monoflux.sinks;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinkMultiDirectAllEx {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");

        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(ConsumerUtil.subscriber("Bob"));

        flux.delayElements(Duration.ofMillis(200)).subscribe(ConsumerUtil.subscriber("Boom"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        ConsumerUtil.sleepSeconds(10);
    }
}
