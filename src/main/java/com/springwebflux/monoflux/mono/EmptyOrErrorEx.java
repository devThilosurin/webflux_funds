package com.springwebflux.monoflux.mono;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;

public class EmptyOrErrorEx {
    public static void main(String[] args) {
        userRepository(20).subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );
    }

    private static Mono<String> userRepository(int userId) {
        return switch (userId) {
            case 1 -> Mono.just(ConsumerUtil.faker().name().fullName());
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Not in the allowed range!"));
        };
    }
}
