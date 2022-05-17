package com.springwebflux.monoflux.combining;

import com.springwebflux.monoflux.helper.AmericanAirlines;
import com.springwebflux.monoflux.helper.Emirates;
import com.springwebflux.monoflux.helper.Qatar;
import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class MergeEx {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(10);
    }
}
