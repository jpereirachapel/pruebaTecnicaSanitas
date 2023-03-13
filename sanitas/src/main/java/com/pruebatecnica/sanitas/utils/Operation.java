package com.pruebatecnica.sanitas.utils;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/");
    /*TODO añadir operaciones mas complejas en el futuro*/

    private static final Operation[] values = new Operation[]{SUMA, RESTA, MULTIPLICACION, DIVISION};

    private String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    private String getSign() {
        return this.sign;
    }

    /**
     * Parsea el parametro String valor en un objeto de tipo Operation.
     * El valor del String puede ser tanto el nombre
     * ("suma", "resta"... indiferente mayusculas de minusculas) de la operacion
     * así como el signo ('+', '-', etc.)
     * @param value
     * @return
     */
    @JsonCreator
    public static Operation fromValor(String value) {

        for (int i = 0; i < values.length; ++i) {
            Operation actualOperation = values[i];
            if (value.equalsIgnoreCase(actualOperation.name()) ||
                    value.equalsIgnoreCase(actualOperation.getSign())) {
                return actualOperation;
            }
        }

        throw new RuntimeException("Operación no soportada para el valor: " + value);
    }
}
