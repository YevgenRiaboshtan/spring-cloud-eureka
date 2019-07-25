package com.example.sum.consumer.service;

import com.example.sum.consumer.model.SumRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SumServiceClientImpl implements SumServiceClient {

    private final WebClient.Builder wcBuilder;

    @Autowired
    public SumServiceClientImpl(@LoadBalanced WebClient.Builder wcBuilder) {
        this.wcBuilder = wcBuilder;
    }

    @Override
    public Mono<String> hello() {
        return wcBuilder.build()
                .get()
                .uri("http://sum-service-provider/hello")
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Mono<String> sum(List<Integer> operands) {
        return wcBuilder.build()
                .post()
                .uri("http://sum-service-provider/sum")
                .body(BodyInserters.fromObject(SumRequestDto.builder().operands(operands).build()))
                .retrieve()
                .bodyToMono(String.class);
    }
}
