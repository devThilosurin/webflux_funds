package com.springwebflux.monoflux.flux_emitting;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class FluxCreateEx {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
//                    for (int i = 0; i < 10; i++) {
//                        fluxSink.next(ConsumerUtil.faker().country().name());
//                    }

                    String country;
                    do {
                        country = ConsumerUtil.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("thailand"));
                    fluxSink.complete();
                })
                .subscribe(ConsumerUtil.subscriber());
    }
}
