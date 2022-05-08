package com.springwebflux.monoflux.mono;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class FromFutureEx {

    public static void main(String[] args) {
        Mono.fromFuture(FromFutureEx::getName).subscribe(ConsumerUtil.onNext());

        ConsumerUtil.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture
                .supplyAsync(() -> ConsumerUtil.faker().name().fullName());
    }
}
