package com.example.sum.provider.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface SumService {
    Mono<String> sum(Flux<BigDecimal> operands);
}
