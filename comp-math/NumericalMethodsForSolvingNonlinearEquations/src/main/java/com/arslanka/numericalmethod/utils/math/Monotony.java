package com.arslanka.numericalmethod.utils.math;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.daos.Equation;
import com.arslanka.numericalmethod.models.daos.Segment;

public class Monotony {
    public static final double EPS = 0.0001;

    public static <T extends BigDecimal> boolean isFunctionMonotony(Equation<BigDecimal> equation, Segment<BigDecimal> segment) {
        boolean positive = segment.leftSide().compareTo(BigDecimal.ZERO) < 0;
        for (double i = segment.leftSide().doubleValue(); i <= segment.rightSide().doubleValue(); i += EPS) {
            BigDecimal val = BigDecimal.valueOf(i);
            if ((Differentiation.findDerivativeResult(equation, val).compareTo(BigDecimal.ZERO) < 0) && positive) {
                return false;
            }
        }
        return true;
    }

}
