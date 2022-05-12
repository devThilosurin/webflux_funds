package com.springwebflux.monoflux.flux_emitting;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class FluxGenerateEx {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("emitting");
                    synchronousSink.next(ConsumerUtil.faker().country().name());
                })
                .take(3)
                .subscribe(ConsumerUtil.subscriber());
    }
}
