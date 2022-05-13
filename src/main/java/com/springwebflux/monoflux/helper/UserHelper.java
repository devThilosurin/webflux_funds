package com.springwebflux.monoflux.helper;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserHelper {
    private int userId;
    private String name;

    public UserHelper(int userId) {
        this.userId = userId;
        this.name = ConsumerUtil.faker().name().fullName();
    }
}
