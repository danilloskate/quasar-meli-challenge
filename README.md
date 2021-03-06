# Operación fuego de Quasar (trilateración y mensajes)


## Introducción

Este Api Rest provee los servicios requeridos por la inteligencia de la operación Fuego de Quasar para la compilación de los mensajes recibidos por los tres satélites (kenobi, skywalker y sato) y determinar la posición de la fuente de estos mensajes.

# Arquitectura

La siguiente es una descripción breve de la arquitectura del api, desarrollada sobre Java 11, utilizando Spring boot y base de datos DB2.

#Paquetes

El siguiente es un listado de los paquetes manejados dentro del api, los cuales distribuyen las clases por sus funcionalidades.

* controller: Clases que reciben peticiones HTTP y exponen los endpoints de los servicios.
* entity: Clases que representan entidades de base de datos.
* exception: Clases que extienden de la clase Exception para manejo de errores.
* dto: Clases que representan los objetos de la aplicación.
* repository: Interfaces usadas por JPA para la interacción con bases de datos.
* service: Clases con lógica de negocio.
* service.util: Clases que exponen funciones utilitarias usadas para la lógica de negocios.

* Para el cumplimiento del Nivel 3 de la Operación se optó por almacenar los datos en una base de datos H2 en memoria.

# Despliegue

La siguiente es una vista de los componentes involucrados en la solución:

https://github.com/danilloskate/quasar-meli-challeng

El Api también se puede descargar y ejecutar por medio de Spring boot, por defecto se desplegará en http://localhost:8080/


