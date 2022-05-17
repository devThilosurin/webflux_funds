package com.springwebflux.monoflux.combining;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class ZipEx {
    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getTires())
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "Body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 3)
                .map(i -> "Engine");
    }

    private static Flux<String> getTires() {
        return Flux.range(1, 5)
                .map(i -> "Tires");
    }
}
