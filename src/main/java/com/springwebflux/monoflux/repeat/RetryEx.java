package com.springwebflux.monoflux.repeat;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryEx {
    public static void main(String[] args) {
        getIntegers()
                .retry(2)
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed..."))
                .doOnComplete(() -> System.out.println("On Completed"))
                .map(i -> i / ConsumerUtil.faker().random().nextInt(0, 1))
                .doOnError(err -> System.out.println("__ERR__"));
    }
}
