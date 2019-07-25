package com.example.sum.provider.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class SumServiceImpl implements SumService {
    @Override
    public Mono<String> sum(Flux<BigDecimal> operands) {
        return operands.reduce(BigDecimal::add).map(sum -> "Sum: " + sum + "\n");
    }
}
