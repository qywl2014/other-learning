package com.wulang.webflux.other;

import com.sun.deploy.net.URLEncoder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;

public class psvm {
    public static void main(String[] args) throws Exception {
        Mono<String> mono = Mono.just("aa");
//        mono.then(Mono.just("bb")).subscribe(System.out::println);
        Mono.defer(()->{
            return Mono.just("33");
        }).subscribe(System.out::println);
    }

}
