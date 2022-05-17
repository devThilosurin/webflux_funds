package com.springwebflux.monoflux.utils;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class ConsumerUtil {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError() {
        return o -> System.out.println("Error : " + o);
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed!");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds) {
        sleepMillis(seconds * 1000);
    }

    public static void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriberUtil();
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriberUtil(name);
    }
}
