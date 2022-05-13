package com.springwebflux.monoflux.helper;

import com.springwebflux.monoflux.utils.ConsumerUtil;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersonHelper {
    private String name;
    private int age;

    public PersonHelper() {
        this.name = ConsumerUtil.faker().name().fullName();
        this.age = ConsumerUtil.faker().random().nextInt(18, 60);
    }
}
