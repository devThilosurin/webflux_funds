package com.springwebflux.monoflux.repeat;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryWhenEx {
    public static void main(String[] args) {
        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed..."))
                .doOnComplete(() -> System.out.println("On Completed"))
                .map(i -> i / ConsumerUtil.faker().random().nextInt(0, 1))
                .doOnError(err -> System.out.println("__ERR__"));
    }
}
