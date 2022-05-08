package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FromStreamEx {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

//        stream.forEach(System.out::println);    // closed

//        Flux<Integer> integerFlux = Flux.fromStream(stream);
        Flux<Integer> integerFlux = Flux.fromStream(list::stream);

        integerFlux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );

        integerFlux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );
    }
}
