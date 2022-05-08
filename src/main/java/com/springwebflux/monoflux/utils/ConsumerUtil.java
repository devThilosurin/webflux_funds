package com.springwebflux.monoflux.utils;

import com.github.javafaker.Faker;

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
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
