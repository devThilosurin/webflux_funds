package com.springwebflux.monoflux.helper;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Qatar {

    public static Flux<String> getFlights() {
        return Flux.range(1, ConsumerUtil.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Qatar " + ConsumerUtil.faker().random().nextInt(100, 999))
                .filter(i -> ConsumerUtil.faker().random().nextBoolean());
    }
}
