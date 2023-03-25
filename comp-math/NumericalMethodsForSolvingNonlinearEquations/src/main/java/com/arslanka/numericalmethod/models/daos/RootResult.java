package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.dtos.RootResultDto;

public record RootResult<T extends BigDecimal, U extends BigDecimal>(
        Integer numberIterations,
        T root,
        U res
) {

    public static <T extends BigDecimal, U extends BigDecimal> RootResult<T, U> of(Integer numberIterations, T root,
                                                                                   U res) {
        return new RootResult<>(numberIterations, root, res);
    }

    public RootResultDto toDto() {
        return new RootResultDto(
                numberIterations,
                root,
                res);
    }
}
