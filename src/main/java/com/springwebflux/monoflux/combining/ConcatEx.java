package com.springwebflux.monoflux.combining;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class ConcatEx {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.error(new RuntimeException("Oops!"));
        Flux<String> flux3 = Flux.just("c", "d", "e");

//        Flux<String> flux = Flux.concat(flux1, flux2, flux3);
        Flux<String> flux = Flux.concatDelayError(flux1, flux2, flux3);
//        Flux<String> flux = flux1.concatWith(flux2);

        flux.subscribe(ConsumerUtil.subscriber());
    }
}
