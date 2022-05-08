package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class RangeEx {
    public static void main(String[] args) {

        Flux.range(3, 10)
                .log()
                .map(i -> ConsumerUtil.faker().name().fullName())
                .log()
                .subscribe(ConsumerUtil.onNext());
    }
}
