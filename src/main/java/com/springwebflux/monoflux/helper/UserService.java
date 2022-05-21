package com.springwebflux.monoflux.helper;

import reactor.core.publisher.Flux;
import reactor.util.context.Context;

import java.util.Map;
import java.util.function.Function;

public class UserService {
    public static Flux<UserHelper> getUsers() {
        return Flux.range(1, 2)
                .map(UserHelper::new);
    }

    private static final Map<String, String> MAP = Map.of(
            "sam", "std",
            "mike", "prime"
    );

    public static Function<Context, Context> userCategoryContext() {
        return ctx -> {
          String user = ctx.get("user").toString();
          String category = MAP.get(user);
          return ctx.put("category", category);
        };
    }
}
