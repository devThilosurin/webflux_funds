package com.springwebflux.monoflux.publishers;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class ColdPublisherEx {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(ColdPublisherEx::getMovie)
                .delayElements(Duration.ofSeconds(2));

        movieStream
                .subscribe(ConsumerUtil.subscriber("sam"));
        ConsumerUtil.sleepSeconds(5);

        movieStream
                .subscribe(ConsumerUtil.subscriber("mike"));
        ConsumerUtil.sleepSeconds(5);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req...");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8",
                "Scene 9"
        );
    }
}
