package com.springwebflux.monoflux.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static Map<Integer, List<PurchaseOrderHelper>> db = new HashMap<>();

    static {
        List<PurchaseOrderHelper> list1 = Arrays.asList(
                new PurchaseOrderHelper(1),
                new PurchaseOrderHelper(1),
                new PurchaseOrderHelper(1)
        );
        List<PurchaseOrderHelper> list2 = Arrays.asList(
                new PurchaseOrderHelper(2),
                new PurchaseOrderHelper(2)
        );

        db.put(1, list1);
        db.put(2, list2);
    }

    public static Flux<PurchaseOrderHelper> getOrder(int userId) {
        return Flux.create((FluxSink<PurchaseOrderHelper> purchaseOrderHelperFluxSink) -> {
            db.get(userId).forEach(purchaseOrderHelperFluxSink::next);
            purchaseOrderHelperFluxSink.complete();
        })
        .delayElements(Duration.ofSeconds(1));
    }
}
