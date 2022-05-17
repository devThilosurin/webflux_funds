package com.springwebflux.monoflux.overflow;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class DropEx {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        ConsumerUtil.sleepMillis(1);
                        System.out.println("Pushed : " + i);
                    }
                    fluxSink.complete();
                })
//                .onBackpressureBuffer()
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> ConsumerUtil.sleepMillis(10))
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(10);
        System.out.println(list);
    }
}
