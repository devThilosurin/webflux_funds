package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.core.publisher.Flux;

public class FromArrayOrListEx {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("a", "b", "c");
//        Flux.fromIterable(strings).subscribe(ConsumerUtil.onNext());

        Integer[] arr = {2, 5, 7, 8};
        Flux.fromArray(arr).subscribe(ConsumerUtil.onNext());
    }
}
