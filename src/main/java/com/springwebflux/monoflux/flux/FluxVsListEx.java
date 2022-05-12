package com.springwebflux.monoflux.flux;

import com.springwebflux.monoflux.helper.NameGenerator;
import com.springwebflux.monoflux.utils.ConsumerUtil;

public class FluxVsListEx {
    public static void main(String[] args) {
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        NameGenerator.getNames(5)
                .subscribe(ConsumerUtil.onNext());
    }
}
