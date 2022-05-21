package com.springwebflux.monoflux.context;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class CtxEx {
    public static void main(String[] args) {
        getWelcomeMessage()
//                .contextWrite(Context.of("user", "jake"))
                .contextWrite(ctx -> ctx.put("user", ctx.get("user").toString().toLowerCase()))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}
