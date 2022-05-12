package com.springwebflux.monoflux.helper;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = ConsumerUtil.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next(thread + " : " + name);
    }
}
