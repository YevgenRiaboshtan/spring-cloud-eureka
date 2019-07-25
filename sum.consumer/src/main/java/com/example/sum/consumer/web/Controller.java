package com.example.sum.consumer.web;

import com.example.sum.consumer.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class Controller {

    private final AppService appService;

    @Autowired
    public Controller(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/info")
    public Flux<String> getInfo() {
        return appService.getInfo();
    }
}
