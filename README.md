# Huellas – Protectora de animales

Este proyecto es una aplicación web hecha con Java y Spring Boot para gestionar los animales de una protectora.

Con la aplicación se pueden dar de alta, listar, filtrar, modificar y eliminar animales haciendo peticiones HTTP, o desde una página HTML que hemos hecho para probarlo todo más cómodo.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- Spring Web
- Lombok
- MapStruct
- Spring Validation
- HTML, CSS y JavaScript

## Arquitectura del proyecto

Para organizar el proyecto hemos usado **Clean Architecture** y **Vertical Slicing**. Esto quiere decir que el código se separa por áreas de negocio (de momento solo tenemos `animal`) y, dentro de cada área, por capas:

- **Domain:** aquí está el modelo `Animal`, los enums (`Especie`, `Sexo`, `Tamano` y `EstadoAdopcion`), los repositorios (solo las interfaces) y las excepciones, como `AnimalNotFoundException`.
- **Application:** aquí están los comandos, los casos de uso y los servicios. Es donde se ejecuta la lógica de la aplicación.
- **Infraestructure:** aquí está lo que conecta con el exterior: el controlador, los DTO, el mapper, la configuración de Spring, las validaciones y el repositorio mock.

También tenemos una carpeta `common` para las cosas que sirven para toda la aplicación, como el manejo global de errores.

## Estructura de carpetas

```
huellas
├── common
│   └── infraestructure/web/error
└── animal
    ├── domain
    │   ├── model
    │   ├── repository
    │   └── error
    ├── application
    │   ├── command
    │   ├── usecase
    │   └── service
    └── infraestructure
        ├── config
        ├── db/repository/mock
        ├── mapper
        └── web
            ├── mvc/controller
            ├── mvc/dto
            └── validation
```

## ¿Cómo funciona una petición?

Cuando el usuario hace una petición, el recorrido es este:

```
Controlador -> Mapper -> Servicio -> Caso de uso -> Repositorio
```

1. El controlador recibe los datos (`AnimalRequest`) y comprueba que son válidos.
2. El mapper convierte esos datos en un comando (`CreateAnimalCommand` o `EditAnimalCommand`).
3. El servicio llama al caso de uso.
4. El caso de uso hace la lógica y usa el repositorio para guardar, buscar o borrar.
5. Al final se devuelve un `AnimalResponse` al usuario.

Los casos de uso y los servicios no tienen anotaciones de Spring. Los creamos nosotros como `@Bean` en la clase `AnimalConfig`, para que la parte de la lógica no dependa del framework.

## Funcionalidades

| Método | Ruta | ¿Qué hace? |
|--------|------|------------|
| GET | `/animales` | Lista todos los animales |
| GET | `/animales?especie=PERRO` | Lista solo los animales de ese tipo |
| GET | `/animales/{id}` | Muestra un animal concreto |
| POST | `/animales` | Da de alta un animal nuevo |
| PUT | `/animales/{id}` | Modifica los datos de un animal |
| DELETE | `/animales/{id}` | Borra un animal |

Al crear un animal, si no se indica el estado, se pone `DISPONIBLE` por defecto. También se guarda automáticamente la fecha en la que se ha dado de alta.

Al editar, solo se pueden cambiar la foto, la edad, el peso, la personalidad, la descripción, el estado y si está vacunado o esterilizado. Hemos decidido que el nombre, la especie, la raza, el sexo y el tamaño no se puedan cambiar, porque son datos que no deberían cambiar una vez que el animal está registrado.

En el PUT hay que mandar el animal completo, porque si falta algún campo de los que se pueden editar, se queda vacío o a 0.

## Validaciones

Cuando se crea un animal se comprueba que:

- El nombre no esté vacío y solo tenga letras y espacios. Esta validación la hemos hecho nosotros con la anotación `@NombreAnimal`. Hemos usado `\p{L}` en la expresión regular en vez de `[a-zA-Z]` para que se acepten tildes y la ñ, porque si no nombres como "Ámbar" darían error.
- La especie y el sexo no estén vacíos.
- La edad esté entre 0 y 30 años. Hemos puesto 30 como máximo porque es raro que un animal de la protectora viva más.
- El peso no sea negativo.
- La personalidad no tenga más de 100 caracteres y la descripción no tenga más de 500.

Los mensajes de error están en el fichero `messages.properties`. Si alguna validación falla, se devuelve un error 400 con la lista de los campos que están mal.

## Errores

Hemos creado una excepción general, `EntityNotFoundException`, de la que hereda `AnimalNotFoundException`. Esta excepción salta cuando se busca, se edita o se borra un animal con un id que no existe.

Para controlar los errores desde un solo sitio hemos creado la clase `GlobalExceptionHandler` con `@ControllerAdvice`:

- Si no se encuentra un animal, se devuelve un error 404.
- Si hay un `NullPointerException`, se devuelve un error 500.

Así el usuario ve una página de error clara, con la fecha, el código y el mensaje, y no se muestran detalles internos del código.

## Datos

De momento no usamos base de datos. Los animales se guardan en memoria con un repositorio mock que empieza con 3 animales de prueba: Max (perro), Pipo y Pepa (agapornis) y Ámbar (gata). Por eso, si se reinicia la aplicación, se pierden los cambios.

## Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir una terminal en la carpeta del proyecto.
3. Ejecutar:

   ```bash
   ./mvnw spring-boot:run
   ```


4. Abrir en el navegador: http://localhost:8080/animales.html

## Cómo probarlo

Desde el navegador:

- http://localhost:8080/animales → ver la lista de animales en JSON
- http://localhost:8080/animales?especie=GATO → ver solo los gatos
- http://localhost:8080/animales.html → dar de alta, listar, filtrar, cambiar el estado y borrar desde una página. Hemos querido hacer una sola página en la que se puedan hacer todas las acciones de la aplicación, con los colores y las fuentes de la guía de estilo de Huellas.

También se puede probar con curl desde la terminal. Por ejemplo, para crear un animal:

```bash
curl -X POST http://localhost:8080/animales -d "nombre=Luna&especie=PERRO&sexo=HEMBRA&edad=4&peso=12"
```

Y para borrar el animal con id 1:

```bash
curl -X DELETE http://localhost:8080/animales/1
```

## Objetivos de aprendizaje

Con esta práctica hemos aprendido a:

- Aplicar Vertical Slicing para organizar las funcionalidades según el área de negocio.
- Organizar una aplicación web con Clean Architecture.
- Crear comandos, casos de uso y servicios.
- Separar los DTO de los modelos de dominio y convertirlos con MapStruct.
- Usar repositorios para acceder a los datos.
- Gestionar las dependencias con Spring (`@Configuration` y `@Bean`).
- Validar los datos que llegan a la aplicación y crear una validación propia.
- Crear excepciones propias y controlar los errores con `@ControllerAdvice`.
- Usar `fetch` desde JavaScript para llamar a la API.
- Probar los endpoints desde el navegador y con curl.

## Mejoras pendientes

- Usar una base de datos real en lugar del repositorio mock.
- Usar plantillas HTML en lugar de escribir el HTML dentro del controlador.
- Poder subir la foto del animal en vez de poner una URL.
- Validar también los datos al editar un animal (PUT), igual que se hace al crearlo.
- Poder editar solo los campos que cambian, sin tener que mandar el animal entero, y avisar al usuario si algún campo se queda vacío.
- Añadir más áreas a la protectora, como adoptantes o solicitudes de adopción.