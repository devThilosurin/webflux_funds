package com.springwebflux.monoflux.mono;

import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1).map(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i * 2;
        });

        stream.forEach(System.out::println);
    }
}
