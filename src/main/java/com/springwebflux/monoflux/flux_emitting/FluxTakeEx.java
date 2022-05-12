package com.springwebflux.monoflux.flux_emitting;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class FluxTakeEx {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .take(3)
                .subscribe(ConsumerUtil.subscriber());
    }
}
