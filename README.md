# Monitoreo de Plantas - Backend 🌿

Este es el backend de la aplicación de monitoreo de plantas, creado con Java y Spring Boot. Se encarga de gestionar los datos de las plantas, sensores y usuarios, así como de proporcionar la API para el frontend.

## Funcionalidades principales ⚙️

*   **Gestión de plantas:** Permite crear, editar y eliminar plantas, así como consultar sus datos (nombre, ubicación, etc.).

*   **Gestión de sensores:** Permite crear, editar y eliminar sensores, así como consultar sus datos (tipo, ubicación, etc.) y las lecturas asociadas.

*   **Gestión de usuarios:** Permite registrar, autenticar y gestionar usuarios, incluyendo la asignación de roles y permisos.

*   **API REST:** Proporciona una API RESTful para que el frontend pueda acceder a los datos y funcionalidades del backend.

## Arquitectura 🏛️

El backend se basa en una arquitectura MVC (Modelo-Vista-Controlador) y utiliza las siguientes tecnologías:

*   **Lenguaje de programación:** Java
*   **Framework:** Spring Boot
*   **Base de datos:** MySQL
*   **ORM:** Spring Data JPA
*   **Seguridad:** Spring Security
*   **Validación:** Bean Validation
*   **Migraciones:** Flyway

## Endpoints de la API 📍

La API proporciona los siguientes endpoints:

*   **Autenticación:**
    *   `POST /api/auth/register`: Registra un nuevo usuario.
    *   `POST /api/auth/login`: Inicia sesión de un usuario.

*   **Estado inicial:**
    *   `GET /api/initial-state`: Obtiene el estado inicial del dashboard para el usuario autenticado.

*   **Plantas:**
    *   `GET /api/plants/{id}`: Obtiene una planta por su ID.
    *   `POST /api/plants`: Crea una nueva planta.
    *   `PUT /api/plants/{id}`: Actualiza una planta existente por su ID.
    *   `DELETE /api/plants/{id}`: Elimina una planta por su ID.

*   **Lecturas:**
    *   `GET /api/plants/{id}/readings`: Obtiene todas las lecturas de una planta por su ID.
    *   `GET /api/readings/{id}`: Obtiene una lectura por su ID.
    *   `PUT /api/readings/{id}`: Actualiza una lectura existente por su ID.
    *   `PUT /api/readings/{id}/change-state`: Activa o desactiva un sensor de una planta por su ID.

## Cómo ejecutar el backend 🚀

1.  Clona este repositorio.
2.  Instala las dependencias con Maven o Gradle.
3.  Configura las variables de entorno, incluyendo la conexión a la base de datos.
4.  Inicia el servidor con `mvn spring-boot:run` o `gradle bootRun`.

## Frontend 💻

El repositorio del frontend de la aplicación se encuentra en el siguiente enlace:

<https://github.com/albelizGH/monitoreo-de-plantas-frontend>
