package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class JustEx {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, "a", ConsumerUtil.faker().name().fullName());

        flux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );
    }


}
