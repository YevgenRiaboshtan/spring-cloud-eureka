package com.example.sum.consumer.service;

import reactor.core.publisher.Mono;

import java.util.List;

public interface SumServiceClient {
    Mono<String> hello();

    Mono<String> sum(List<Integer> operands);

}
