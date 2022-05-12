package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelayEx {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }
}
