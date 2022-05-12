package com.springwebflux.monoflux.utils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriberUtil implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriberUtil(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriberUtil() {

    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + " Received : " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " Error : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " Completed!");
    }
}
