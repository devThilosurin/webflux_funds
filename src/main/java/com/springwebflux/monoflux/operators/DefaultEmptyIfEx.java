package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class DefaultEmptyIfEx {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-1)
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
//        return Flux.range(1, 10);
        return Flux.range(1, 12);
    }
}
