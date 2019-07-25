package com.example.sum.provider.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SumRequestDto {

    @NotNull
    @Size(min = 1)
    private List<BigDecimal> operands;
}
