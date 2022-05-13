package com.springwebflux.monoflux.operators;

import com.springwebflux.monoflux.helper.OrderService;
import com.springwebflux.monoflux.helper.UserHelper;
import com.springwebflux.monoflux.helper.UserService;
import com.springwebflux.monoflux.utils.ConsumerUtil;

public class FlatMapEx {
    public static void main(String[] args) {
        UserService.getUsers()
                .map(UserHelper::getUserId)
                .flatMap(OrderService::getOrder)
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }
}
