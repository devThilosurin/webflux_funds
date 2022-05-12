package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class LimitRateEx {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100)
                .subscribe(ConsumerUtil.subscriber());
    }
}
