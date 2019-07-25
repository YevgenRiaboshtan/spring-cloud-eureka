package com.example.sum.provider.web;

import com.example.sum.provider.model.SumRequestDto;
import com.example.sum.provider.service.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class SumController {

    private final SumService sumService;

    @Autowired
    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping("/sum")
    public Mono<String> sum(@Valid @RequestBody SumRequestDto request) {
        return sumService.sum(Flux.fromIterable(request.getOperands()));
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello world; UUID: " + UUID.randomUUID().toString() + "\n");
    }
}
