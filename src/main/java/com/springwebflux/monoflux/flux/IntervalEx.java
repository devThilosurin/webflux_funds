package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class IntervalEx {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(ConsumerUtil.onNext());
        ConsumerUtil.sleepSeconds(5);
    }
}
