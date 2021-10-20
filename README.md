# De Java a Kotlin: Adoptar y refactorizar

![](images/header_transparent.png)

## Acerca de este workshop

En los últimos años Kotlin ha ganado gran popularidad y demanda dentro de la industria. Aunque existen herramientas que permiten migrar de Java a Kotlin en algunos clicks, estas no permiten explotar completamente el lenguaje. El objetivo del workshop es poder migrar un código existente en Java a Kotlin, explorar lo que el IDE no nos sugiere. 

## Pre-requisitos

Orientado a desarrolladores de todos los niveles que hayan tenido algo de experiencia con Java, Spring Boot y APIs REST.

## Speakers

### Joaquin Campero

Development Practice Lead @ redbee studios. En el rol de practice lead asegura la excelencia técnica dentro de la práctica de desarrollo tanto en herramientas como procesos de ingeniería, y además vela por el crecimiento profesional de los equipos. Actualmente está como arquitecto en Todo Pago.

### Matias San Martin

Expert Engineer @ Prisma Medios de Pago, forma parte del nuevo equipo de Arquitectura y trabaja junto a un equipo en la definición e implementación de nuevos estándares técnicos y metodológicos que mejoren el ciclo de vida de desarrollo

### Sebastian Martinez

Sr Engineer @ redbee studios, Sebas es uno de nuestros expertos en microservicios en java y particularmente kotlin. Actualmente es uno de los referentes en arquitectura de pagos digitales de redbee.

## Caso de uso

El workshop plantea un escenario de negocio asociado a la industria de medios de pago. El objetivo principal es poder disponibilizar un servicio REST mediante el cual se pueda ejecutar (con muchas asunciones y omisiones) un pago a través de un código QR.

En este escenario, aparecen las siguientes entidades:

**Buyer**: Representa a la persona compradora. Posee un **PaymentMethod** a través del cual realiza el pago

**Seller**: Representa a un comercio vendedor. Disponibiliza un **QR** para poder efectuar el pago.

**PaymentMethod**: El medio de pago utilizado por la persona compradora, puede ser una tarjeta de crédito o débito.

**QR**: Representa el código QR a través del cual se cursa el pago

La ejecución efectiva del pago es realizada por un gateway, que en el contexto del caso de uso se modela como una entidad **Authorization**.