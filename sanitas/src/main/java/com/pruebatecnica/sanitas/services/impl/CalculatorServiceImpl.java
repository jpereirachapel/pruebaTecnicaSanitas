package com.pruebatecnica.sanitas.services.impl;

import com.pruebatecnica.sanitas.services.CalculatorService;
import com.pruebatecnica.sanitas.utils.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementación básica de la interfaz {@link CalculatorService}
 */

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceImpl.class);


    /**
     * Intentamos convertir la operación, sino podemos lanzamos un error,
     * y realizamos la operación correspondiente
     * @param firstNumber
     * @param secondNumber
     * @param operationText
     * @return
     */
    
    @Override
    public double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operationText) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calculando resultado para : {} {} {}", firstNumber, secondNumber, operationText);
        }

        Operation operation = Operation.fromValor(operationText);

        if(operation == null) {
            throw new RuntimeException("Operación imposible de procesar: " + operationText);
        }

        switch (operation) {
            case SUMA:
                return firstNumber.add(secondNumber).doubleValue();
            case RESTA:
                return firstNumber.subtract(secondNumber).doubleValue();
            case MULTIPLICACION:
                return firstNumber.multiply(secondNumber).doubleValue();
            case DIVISION:
                return firstNumber.divide(secondNumber, 2, RoundingMode.HALF_UP).doubleValue();
            default:
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error("Operación no soportada para ser calculada: {}", operation);
                }
                throw new RuntimeException("Operación no soportada para ser calculada: " + operation.toString());

        }
    }
}
