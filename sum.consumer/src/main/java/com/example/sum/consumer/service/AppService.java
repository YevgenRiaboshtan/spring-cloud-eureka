package com.example.sum.consumer.service;

import reactor.core.publisher.Flux;

public interface AppService {

    Flux<String> getInfo();
}
