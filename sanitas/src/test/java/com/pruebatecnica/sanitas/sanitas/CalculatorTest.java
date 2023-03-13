package com.pruebatecnica.sanitas.sanitas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
public class CalculatorTest {
    @LocalServerPort
    int randomServerPort;

    /**
     * Invoca una llamada GET localhost:(puerto_aleatorio)/api/calcula con los parametros de la funcion
     * @param first
     * @param second
     * @param operation
     * @return
     * @throws URISyntaxException
     */
    private ResponseEntity<Double> calculate(double first, double second, String operation) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/api/calcula?primero=" + first +
                "&segundo=" + second + "&operacion=" + operation;
        URI uri = new URI(baseUrl);

        ResponseEntity<Double> result = restTemplate.getForEntity(uri, Double.class);
        return result;
    }

    @Test
    public void testSumaOk() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculate(4, 6, "suma");

        //Comprueba el resultado
        Assert.assertEquals(200, resultado.getStatusCodeValue());
        Assert.assertEquals(10.0d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestaOk() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculate(4, 6, "resta");

        //Comprueba el resultado
        Assert.assertEquals(200, resultado.getStatusCodeValue());
        Assert.assertEquals(-2.0d, resultado.getBody().doubleValue(), 0.001d);
    }


    @Test
    public void testMultiplicacionOk() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculate(40, 10, "multiplicacion");

        //Comprueba el resultado
        Assert.assertEquals(200, resultado.getStatusCodeValue());
        Assert.assertEquals(400.0d, resultado.getBody().doubleValue(), 0.001d);
    }


    @Test
    public void testDivisionOk() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculate(40, 10, "division");

        //Comprueba el resultado
        Assert.assertEquals(200, resultado.getStatusCodeValue());
        Assert.assertEquals(4.0d, resultado.getBody().doubleValue(), 0.001d);
    }
}