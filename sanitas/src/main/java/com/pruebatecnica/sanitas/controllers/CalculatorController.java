package com.pruebatecnica.sanitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.pruebatecnica.sanitas.services.CalculatorService;

import io.corp.calculator.TracerImpl;

import java.math.BigDecimal;

/**
 * Gestiona el método GET /api/calcula
 */
@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    private TracerImpl tracer = new TracerImpl();


    @GetMapping(value = "/calcula")
    public ResponseEntity<Double> calcula(@RequestParam(name = "primero") BigDecimal firstNumber,
                                            @RequestParam(name = "segundo") BigDecimal secondNumber,
                                            @RequestParam(name = "operacion") String operation) {

        double result = this.calculatorService.calculate(firstNumber, secondNumber, operation);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
