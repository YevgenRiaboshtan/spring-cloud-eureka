package com.example.sum.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AppServiceImpl implements AppService {

    private final static Random RANDOM = new Random(System.currentTimeMillis());
    private final static int RANDOM_LIMIT = 10;
    private final SumServiceClient sumServiceClient;

    @Autowired
    public AppServiceImpl(SumServiceClient sumServiceClient) {
        this.sumServiceClient = sumServiceClient;
    }

    @Override
    public Flux<String> getInfo() {
        List<Integer> operands = getOperands();
        return Flux.merge(getHello(), getOperandsInfo(operands), getSum(operands));
    }

    private Mono<String> getHello() {
        return sumServiceClient.hello();
    }

    private Mono<String> getOperandsInfo(List<Integer> operands) {
        return Mono.just("operands: [" + operands.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]\n");
    }

    private Mono<String> getSum(List<Integer> operands) {
        return sumServiceClient.sum(operands);
    }

    private List<Integer> getOperands() {
        return RANDOM.ints(RANDOM_LIMIT, 0, RANDOM_LIMIT).boxed().collect(Collectors.toList());
    }
}
