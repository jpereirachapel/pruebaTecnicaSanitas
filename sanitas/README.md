# Calculadora Spring-Boot
Calculadora como micro-servicio (API) utilizando Spring-boot y Maven con funcionalidades básicas de sumar, restar, multiplicar y dividir.

Comunicación a través de una API REST (p.e. ```GET /api/calcula?primero=2&segundo=3&operacion=suma```)

Contiene la integración de las librerías locales [tracer](https://github.com/jpereirachapel/pruebaTecnicaSanitas/tree/main/sanitas/lib) en maven  por lo que es necesario ejecutar `mvn clean install` antes de poder utilizar el proyecto.

## Requisitos previos
Necesario disponer de la ultima versión de MAVEN y JAVA instaladas.

## Como utilizar

1. Descargar el repositorio github
2. Ejecutar una verificación de Maven
3. Instalación limpia de Maven
4. Ejecutar el JAR de la carpeta /target

Abrir una consola y ejecutar:

```
git clone https://github.com/RotaruDan/calculadora
cd calculadora
mvn validate
mvn verify
mvn clean install
```

A estas alturas debería haberse generado una carpeta `/target` con el JAR definitivo del programa `calculadora-spring-boot.jar`. Para ejecutarlo:

`java -jar target/calculadora-spring-boot.jar`

Con estos pasos deberiamos tener a nuestra disposición una API REST escuchando en `http://localhost:8080/api/calcula`

## API REST
Si has seguido correctamente los pasos anteriores, deberias tener el puerto 8080 abierto y escuchando peticiones REST GET.

Los parámetros se le deben pasar por URL en formato URLEncoded. Los parametros son los siguientes `first` el primer numero de la operación,
`second` el segundo numero de la operación y `operation` una cadena de texto describiendo la operación a realizar (valores aceptados `suma`, `resta`, `multiplicación`, `division`). Por ejemplo:

`GET http://localhost:8080/api/calcula?first=4&second=9&operation=suma`

El resultado será un valor numerico con decimales (4 + 9 = 13):

`13.0`

## Ejecutar tests

Si has clonado e instalado todas las dependencias de maven en local, para ejecutar los [tests](https://github.com/jpereirachapel/pruebaTecnicaSanitas/tree/main/sanitas/src/test/java/com/pruebatecnica/sanitas/sanitas) debes ejecutar el comando `mvn clean test`.
