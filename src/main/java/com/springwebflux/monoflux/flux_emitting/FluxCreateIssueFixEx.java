package com.springwebflux.monoflux.flux_emitting;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFixEx {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    int counter = 0;
                    do {
                        country = ConsumerUtil.faker().country().name();
                        fluxSink.next(country);
                        counter++;
                    } while (!country.equalsIgnoreCase("thailand") && !fluxSink.isCancelled() && counter < 10);
                    fluxSink.complete();
                })
//                .take(3)
                .subscribe(ConsumerUtil.subscriber());
    }
}
