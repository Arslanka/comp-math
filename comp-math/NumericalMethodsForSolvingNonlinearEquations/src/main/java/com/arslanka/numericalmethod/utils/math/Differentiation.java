package com.arslanka.numericalmethod.utils.math;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.daos.Equation;

public class Differentiation {
    private static final BigDecimal EPS = BigDecimal.valueOf(0.001);

    public static <T extends BigDecimal> BigDecimal findDerivativeResult(Equation<BigDecimal> equation,
                                                                         BigDecimal val) {
        return equation.substitute(val.add(EPS)).subtract(equation.substitute(val)).divide(EPS);
    }
}
