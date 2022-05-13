package com.springwebflux.monoflux.helper;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrderHelper {
    private String item;
    private String price;
    private int userId;

    public PurchaseOrderHelper(int userId) {
        this.userId = userId;
        this.item = ConsumerUtil.faker().commerce().productName();
        this.price = ConsumerUtil.faker().commerce().price();
    }
}
