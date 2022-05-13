package com.springwebflux.monoflux.helper;

import reactor.core.publisher.Flux;

public class UserService {
    public static Flux<UserHelper> getUsers() {
        return Flux.range(1, 2)
                .map(UserHelper::new);
    }
}
