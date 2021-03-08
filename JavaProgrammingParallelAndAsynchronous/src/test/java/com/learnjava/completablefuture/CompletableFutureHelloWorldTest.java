package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.CommonUtil.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureHelloWorldTest {

    HelloWorldService hws = new HelloWorldService();
    CompletableFutureHelloWorld cfhw = new CompletableFutureHelloWorld(hws);

    @Test
    void helloWorld() {

        //given

        //when
        CompletableFuture<String> completableFuture = cfhw.helloWorld();

        //then
        completableFuture
                .thenAccept(s -> {
                    assertEquals("HELLO WORLD", s);
                })
                .join();
    }

    @Test
    void helloworld_muliple_async_calls() {
        //given
        stopWatchReset();
        //when
        String helloWorld = cfhw.helloworld_muliple_async_calls();

        //then
        assertEquals("HELLO WORLD!", helloWorld);
    }

    @Test
    void helloworld_3_async_calls() {
        //given
        stopWatchReset();
        //when
        String helloWorld = cfhw.helloworld_3_async_calls();

        //then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", helloWorld);
    }

    @Test
    void helloworld_3_async_calls_log() {
        //given

        //when
        String helloWorld = cfhw.helloworld_3_async_calls_log();

        //then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", helloWorld);
    }

    @Test
    void helloworld_3_async_calls_custom_threadpool() {
        //given

        //when
        String helloWorld = cfhw.helloworld_3_async_calls_custom_threadpool();

        //then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", helloWorld);
    }

    @Test
    void helloWorld_thenCompose() {
        //given
        stopWatchReset();
        startTimer();
        //when
        CompletableFuture<String> completableFuture = cfhw.helloWorld_thenCompose();

        //then
        completableFuture
                .thenAccept(s -> {
                    assertEquals("HELLO WORLD!", s);
                })
                .join();

        timeTaken();
    }
}