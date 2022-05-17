package com.springwebflux.monoflux.combining;

import com.springwebflux.monoflux.helper.NameGenerator;
import com.springwebflux.monoflux.utils.ConsumerUtil;

public class StartWithEx {
    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();

        generator.generateNames()
                .take(2)
                .subscribe(ConsumerUtil.subscriber("SAM"));

        generator.generateNames()
                .take(2)
                .subscribe(ConsumerUtil.subscriber("MIKE"));

//        generator.generateNames()
//                .take(3)
//                .subscribe(ConsumerUtil.subscriber("BOB"));

        generator.generateNames()
                .filter(n -> n.startsWith("B"))
                .take(2)
                .subscribe(ConsumerUtil.subscriber("BOB"));
    }
}
