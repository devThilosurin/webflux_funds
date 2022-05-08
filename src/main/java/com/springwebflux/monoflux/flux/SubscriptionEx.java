package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class SubscriptionEx {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onCompleted!");
                    }
                });

        ConsumerUtil.sleepSeconds(3);
        atomicReference.get().request(3);
        ConsumerUtil.sleepSeconds(5);
        atomicReference.get().request(3);
        ConsumerUtil.sleepSeconds(5);
        System.out.println("going to cancel...");
        atomicReference.get().cancel();
        ConsumerUtil.sleepSeconds(3);
        atomicReference.get().request(4);

        ConsumerUtil.sleepSeconds(3);
    }
}
