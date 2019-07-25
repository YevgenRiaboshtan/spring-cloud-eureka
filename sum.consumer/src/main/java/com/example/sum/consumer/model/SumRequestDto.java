package com.example.sum.consumer.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class SumRequestDto {

    private List<Integer> operands;
}
