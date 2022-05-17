package com.springwebflux.monoflux.helper;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    /*
    public static List<String> getNames(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) list.add(getName());
        return list;
    }
     */

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count).map(i -> getName());
    }

    private static String getName() {
        ConsumerUtil.sleepSeconds(1);
        return ConsumerUtil.faker().name().fullName();
    }

    private List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(stringSynchronousSink -> {
                    System.out.println("Generated Fresh >>> ");
                    ConsumerUtil.sleepSeconds(1);
                    String name = ConsumerUtil.faker().name().fullName();
                    list.add(name);
                    stringSynchronousSink.next(name);
                })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}
