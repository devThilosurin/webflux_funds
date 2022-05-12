package com.springwebflux.monoflux.flux_emitting;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class FluxGenerateCounterEx {
    public static void main(String[] args) {
        Flux.generate(
                        () -> 1,
                        (counter, sink) -> {
                            String country = ConsumerUtil.faker().country().name();
                            sink.next(country);
                            if (counter >= 10 || country.equalsIgnoreCase("thailand")) {
                                sink.complete();
                            }
                            return ++counter;
                        }
                )
                .subscribe(ConsumerUtil.subscriber());
    }
}
