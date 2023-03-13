package com.pruebatecnica.sanitas.services;


import java.math.BigDecimal;

public interface CalculatorService {

    /**
     * Method is used for calculation for given numbers and operator type
     * Calcula para los números proporcionados como argumentos el resultado de
     * la operación
     *
     * @param firstNumber
     * @param secondNumber
     * @param operation sumar, restar, multiplicar, dividir...
     * @return el resultado de la operación (depende del tipo de operación). Se ha decidido que valor doble
     *              es más que suficiente para representar la operación
     */
    double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operation);
}
