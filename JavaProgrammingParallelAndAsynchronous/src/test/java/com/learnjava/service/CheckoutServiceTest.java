package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.ForkJoinPool;

import static com.learnjava.util.LoggerUtil.log;

import static com.learnjava.util.CommonUtil.stopWatchReset;
import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {


    PriceValidatorService priceValidatorService = new PriceValidatorService();
    CheckoutService checkoutService = new CheckoutService(priceValidatorService);

    @Test
    void no_Of_cores() {
        //given

        //when
        System.out.println("no of cores :" + Runtime.getRuntime().availableProcessors());

        //then
    }

    @Test
    void parallelism() {
        //given

        //when
        log("parallelism :" + ForkJoinPool.getCommonPoolParallelism());

        //then
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void checkout_6_items(int number) {
        //given
        stopWatchReset();
        Cart cart= DataSet.createCart(number);

        //when
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.SUCCESS, checkoutResponse.getCheckoutStatus());
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 11, 13,25})
    void checkout_13_items(int number) {
        //given
        stopWatchReset();
        Cart cart= DataSet.createCart( number);

        //when
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
    }

    @Test
    void modify_parallelism() {
        //given
        stopWatchReset();
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100");
        Cart cart= DataSet.createCart( 100 );

        //when
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
    }

}