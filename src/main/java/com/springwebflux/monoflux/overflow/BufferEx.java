package com.springwebflux.monoflux.overflow;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BufferEx {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                    }
                    fluxSink.complete();
                })
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> ConsumerUtil.sleepMillis(10))
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }
}
