package com.springwebflux.monoflux.context;

import com.springwebflux.monoflux.helper.BookService;
import com.springwebflux.monoflux.helper.UserService;
import com.springwebflux.monoflux.utils.ConsumerUtil;
import reactor.util.context.Context;

public class CtxRateLimiterEx {
    public static void main(String[] args) {
        BookService
                .getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "sam"))
                .subscribe(ConsumerUtil.subscriber());
    }
}
