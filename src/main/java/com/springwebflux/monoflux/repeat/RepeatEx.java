package com.springwebflux.monoflux.repeat;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class RepeatEx {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        getIntegers()
//                .repeat(2)
                .repeat(() -> atomicInteger.get() < 7)
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed..."))
                .doOnComplete(() -> System.out.println("On Completed"))
                .map(i -> atomicInteger.getAndIncrement());
    }
}
