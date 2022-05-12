package com.springwebflux.monoflux.flux_emitting;

import com.springwebflux.monoflux.helper.NameProducer;
import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class FluxPushEx {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(ConsumerUtil.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        ConsumerUtil.sleepSeconds(2);
    }
}
