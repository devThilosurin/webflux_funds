package com.springwebflux.monoflux.sinks;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkOneEx {
    public static void main(String[] args) {
        // mono 1 value / empty / error
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();

        mono.subscribe(ConsumerUtil.subscriber("sam"));

//        sink.tryEmitValue("hi");
//        sink.tryEmitEmpty();
//        sink.tryEmitError(new RuntimeException("-- ERR --"));

        sink.emitValue("hi", (signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        });

        sink.emitValue("hello", (signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        });
    }
}
