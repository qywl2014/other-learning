package com.wulang.webflux.other;

import org.junit.Test;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ReactiveTest {

    @Test
    public void fluxThen(){
        Flux<String> flux = Flux.just("442","443").map(t->{
            System.out.println(t);
            return t+1;
        });
//        flux.subscribe(System.out::println,System.err::println,()->System.out.println("flux complete..."));
        Mono<String> mono1 = flux.then(Mono.just("mono1"));
        mono1.subscribe(System.out::println,System.err::println,()->System.out.println("mono complete..."));
    }

    @Test
    public void monoThen(){//then: 在subscribe时,会跑一遍自己的subscribe,map,filter等，数据用新的
        Mono<String> mono = Mono.just("442").map(t->{
            System.out.println("map...");
            System.out.println(t);
            return t+1;
        }).filter(t->{
            System.out.println(t+1);
            return true;
        });
//        mono.subscribe(System.out::println,System.err::println,()->System.out.println("flux complete..."));
        Mono<String> mono1 = mono.then(Mono.just("mono1"));
        mono1.subscribe(System.out::println,System.err::println,()->System.out.println("mono complete..."));
    }

    @Test
    public void monoDefer(){//defer: 在subscribe时，会调用supplier,然后逻辑都委托给获得的mono，数据都是原来的
        Mono<String> mono = Mono.defer(() -> {
            System.out.println("supply");
            return Mono.just("a").map(t -> {
                System.out.println(t);
                return t + 1;
            });
        }).map(t->{
            System.out.println("map"+t);
            return t;
        });
        Mono<String> mono1 = mono.then(Mono.just("mono1"));
        mono1.subscribe(System.out::println,System.err::println,()->System.out.println("mono complete..."));
    }

    @Test
    public void generate(){
        Flux.generate(sink -> {
            sink.next("Hello");
//            sink.complete();
        }).subscribe(System.out::println);
    }

    public Mono<ThreadPoolExecutor> get(){
        return Mono.empty();
    }
}
