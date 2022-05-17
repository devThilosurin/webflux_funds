package com.springwebflux.monoflux.repeat;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.util.function.Function;

public class RetryWhenAdvancedEx {
    private static final Function<String, Function<String, Boolean>> isErrOnStatusCode = errMessage -> errMessage::equals;

    public static void main(String[] args) {
        orderService(ConsumerUtil.faker().business().creditCardNumber())
//                .doOnError(err -> System.out.println(err.getMessage()))
//                .retry(5)
                .retryWhen(Retry.from(flux -> flux
                        .doOnNext(rs -> {
                            System.out.println(rs.totalRetries());
                            System.out.println(rs.failure());
                        })
                        .handle((rs, synchronousSink) -> {
                            var isErr = isErrOnStatusCode.apply(rs.failure().getMessage());
                            if (Boolean.TRUE.equals(isErr.apply("500"))) {
                                synchronousSink.next(1);
//                            } else if (Boolean.TRUE.equals(isErr.apply("404"))) {
//                                synchronousSink.next(2);
                            } else {
                                synchronousSink.error(rs.failure());
                            }
                        })
                ))
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }

    // Order Service
    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return ConsumerUtil.faker().idNumber().valid();
        });
    }

    // Payment Service
    private static void processPayment(String ccNumber) {
        int rdm = ConsumerUtil.faker().random().nextInt(1, 10);

        if (rdm < 8) {
            throw new RuntimeException("500");
        } else if (rdm < 10) {
            throw new RuntimeException("404");
        }
    }
}
