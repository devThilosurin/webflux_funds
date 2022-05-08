package com.springwebflux.monoflux.mono;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Mono;

public class FromRunnableEx {
    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess()).subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                () -> {
                    System.out.println("Process is done. Sending Emails...");
                }
        );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            ConsumerUtil.sleepSeconds(3);
            System.out.println("Operation Complete!");
        };
    }
}
