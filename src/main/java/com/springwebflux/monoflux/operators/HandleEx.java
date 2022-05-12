package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class HandleEx {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer % 2 == 0) {
                        synchronousSink.next(integer);  // filter
                    } else {
                        synchronousSink.next(integer + "a");    // map
                    }
                })
                .subscribe(ConsumerUtil.subscriber());
    }
}
