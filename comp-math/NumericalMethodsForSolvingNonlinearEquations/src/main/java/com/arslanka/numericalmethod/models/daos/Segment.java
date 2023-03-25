package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

public record Segment<T extends BigDecimal>(
        T leftSide,
        T rightSide
){}
