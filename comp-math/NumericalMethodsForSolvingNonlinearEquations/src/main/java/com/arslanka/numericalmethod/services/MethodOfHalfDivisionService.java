package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.daos.Equation;
import com.arslanka.numericalmethod.models.daos.RootResult;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.utils.math.Monotony;
import org.springframework.stereotype.Service;

@Service
public class MethodOfHalfDivisionService {

    public RootResult<BigDecimal, BigDecimal> solveEquation(Equation<BigDecimal> equation,
                                                            Segment<BigDecimal> segment, BigDecimal eps) {
        if (!Monotony.isFunctionMonotony(equation, segment)) {
            throw new RuntimeException();
        }
        if (equation.substitute(segment.rightSide()).multiply(equation.substitute(segment.leftSide())).compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException();
        }
        return solve(equation, segment.leftSide(), segment.rightSide(), eps);
    }

    private RootResult<BigDecimal, BigDecimal> solve(Equation<BigDecimal> equation, BigDecimal left, BigDecimal right,
                                                     BigDecimal eps) {
        BigDecimal curApproxRes;
        Integer iterations = 0;
        do {
            curApproxRes = left.add(right).divide(BigDecimal.valueOf(2));
            if (equation.substitute(left).multiply(equation.substitute(curApproxRes)).compareTo(BigDecimal.ZERO) > 0) {
                left = curApproxRes;
            } else {
                right = curApproxRes;
            }

            iterations++;
        } while (right.subtract(left).abs().compareTo(eps) >= 0);
        return RootResult.of(iterations, curApproxRes, equation.substitute(curApproxRes));
    }
}
