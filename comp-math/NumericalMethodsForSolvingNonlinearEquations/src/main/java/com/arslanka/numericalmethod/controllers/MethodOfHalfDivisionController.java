package com.arslanka.numericalmethod.controllers;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.daos.Equation;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.models.daos.SimplePowerEquation;
import com.arslanka.numericalmethod.models.dtos.RootResultDto;
import com.arslanka.numericalmethod.services.MethodOfHalfDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/half-division")
public class MethodOfHalfDivisionController {

    private final MethodOfHalfDivisionService methodOfHalfDivisionService;

    @Autowired
    public MethodOfHalfDivisionController(MethodOfHalfDivisionService methodOfHalfDivisionService) {
        this.methodOfHalfDivisionService = methodOfHalfDivisionService;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    ResponseEntity<RootResultDto> solve(@RequestBody String equation) {
        Equation<BigDecimal> equation1 = new SimplePowerEquation(3)
                .add(new SimplePowerEquation(1).multiply(BigDecimal.valueOf(-1)))
                .add(BigDecimal.valueOf(4));
        return ResponseEntity.ok(methodOfHalfDivisionService.solveEquation(
                        equation1,
                        new Segment<>(BigDecimal.valueOf(-2), BigDecimal.valueOf(-1)),
                        BigDecimal.valueOf(0.01)
                ).toDto()
        );
    }

}
