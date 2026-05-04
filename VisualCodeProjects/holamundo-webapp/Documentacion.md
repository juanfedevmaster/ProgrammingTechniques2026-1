# Documentación del Proyecto: holamundo-webapp

## 1. Descripción General

**holamundo-webapp** es una aplicación web de tipo **REST API** construida con Spring Boot. Es un proyecto introductorio que expone un único endpoint HTTP y sirve como base para aprender el desarrollo de APIs con el ecosistema de Spring.

---

## 2. Stack Tecnológico

| Tecnología | Versión | Propósito |
|---|---|---|
| Java | 21 | Lenguaje de programación |
| Spring Boot | 3.5.14 | Framework principal |
| Spring Web (MVC) | (gestionada por Spring Boot) | Capa HTTP / REST |
| SpringDoc OpenAPI | 2.8.16 | Documentación automática Swagger UI |
| Lombok | (gestionada por Spring Boot) | Reducción de código repetitivo |
| Spring Boot DevTools | (gestionada por Spring Boot) | Recarga automática en desarrollo |
| Spring Boot Test | (gestionada por Spring Boot) | Framework de pruebas |
| Maven | Wrapper incluido | Gestión de dependencias y construcción |

---

## 3. Estructura del Proyecto

```
holamundo-webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/juanfedevmaster/holamundowebapp/
│   │   │       ├── HolamundoWebappApplication.java   ← Clase principal
│   │   │       └── controllers/
│   │   │           └── HolaMundoController.java      ← Controlador REST
│   │   └── resources/
│   │       ├── application.properties                ← Configuración
│   │       ├── static/                               ← (vacío) Recursos estáticos
│   │       └── templates/                            ← (vacío) Plantillas HTML
│   └── test/
│       └── java/
│           └── com/juanfedevmaster/holamundowebapp/
│               └── HolamundoWebappApplicationTests.java ← Test de contexto
├── pom.xml                                           ← Definición del proyecto Maven
├── mvnw / mvnw.cmd                                   ← Maven Wrapper
└── HELP.md                                           ← Ayuda generada por Spring Initializr
```

---

## 4. Análisis de Componentes

### 4.1 Clase Principal — `HolamundoWebappApplication.java`

```java
@SpringBootApplication
public class HolamundoWebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(HolamundoWebappApplication.class, args);
    }
}
```

- Anotada con `@SpringBootApplication`, que combina `@Configuration`, `@EnableAutoConfiguration` y `@ComponentScan`.
- Es el punto de entrada de la aplicación. Al ejecutarse, Spring Boot inicializa el contexto, configura el servidor embebido Tomcat y registra todos los beans detectados.

---

### 4.2 Controlador REST — `HolaMundoController.java`

```java
@RestController
public class HolaMundoController {

    @GetMapping("/hola")
    public String getHolaMundo() {
        return "Hola mundo desde mi primera aplicacion WebApi!!";
    }
}
```

| Aspecto | Detalle |
|---|---|
| Anotación | `@RestController` = `@Controller` + `@ResponseBody` |
| Método HTTP | `GET` |
| Ruta | `/hola` |
| Tipo de respuesta | `String` (texto plano, `text/plain`) |
| Código HTTP de éxito | `200 OK` |

**Comportamiento:** Al realizar una petición `GET` a `http://localhost:8080/hola`, el servidor responde con el texto:
```
Hola mundo desde mi primera aplicacion WebApi!!
```

---

### 4.3 Configuración — `application.properties`

```properties
spring.application.name=holamundo-webapp
```

- Solo define el nombre de la aplicación.
- El servidor HTTP corre en el **puerto 8080** (valor por defecto de Spring Boot).
- No hay configuración de base de datos, seguridad, ni logging personalizado.

---

### 4.4 Pruebas — `HolamundoWebappApplicationTests.java`

```java
@SpringBootTest
class HolamundoWebappApplicationTests {

    @Test
    void contextLoads() {
    }
}
```

- Usa `@SpringBootTest` para levantar el contexto completo de Spring durante la prueba.
- El test `contextLoads()` verifica que la aplicación arranca sin errores de configuración.
- Es el test de sanidad base generado por Spring Initializr.

---

### 4.5 Dependencias Maven — `pom.xml`

| Dependencia | Scope | Descripción |
|---|---|---|
| `spring-boot-starter-web` | compile | Incluye Spring MVC + Tomcat embebido |
| `springdoc-openapi-starter-webmvc-ui` | compile | Genera Swagger UI en `/swagger-ui.html` |
| `spring-boot-devtools` | runtime/optional | Recarga automática al cambiar código |
| `lombok` | optional | Generación de código (getters, setters, etc.) mediante anotaciones |
| `spring-boot-starter-test` | test | JUnit 5, Mockito, AssertJ para pruebas |

---

## 5. Endpoints Disponibles

| Método | Ruta | Descripción | Respuesta |
|---|---|---|---|
| `GET` | `/hola` | Saludo inicial | `"Hola mundo desde mi primera aplicacion WebApi!!"` |
| `GET` | `/swagger-ui.html` | Interfaz Swagger UI (SpringDoc) | Página HTML interactiva |
| `GET` | `/v3/api-docs` | Especificación OpenAPI en formato JSON | JSON |

---

## 6. Cómo Ejecutar el Proyecto

### Usando Maven Wrapper (recomendado)

```bash
# En macOS/Linux
./mvnw spring-boot:run

# En Windows
mvnw.cmd spring-boot:run
```

### Compilar y ejecutar el JAR

```bash
./mvnw clean package
java -jar target/holamundo-webapp-0.0.1-SNAPSHOT.jar
```

### Ejecutar pruebas

```bash
./mvnw test
```

Una vez iniciada, la aplicación estará disponible en: `http://localhost:8080`

---

## 7. Observaciones y Posibles Mejoras

- **Sin capa de servicio:** La lógica está directamente en el controlador. Para proyectos más grandes, conviene separar la lógica de negocio en clases `@Service`.
- **Sin persistencia:** No hay base de datos ni repositorios configurados.
- **Sin seguridad:** No se incluye Spring Security; todos los endpoints son públicos.
- **Carpetas vacías:** `static/` y `templates/` están vacías, indicando que no hay frontend servido desde la aplicación.
- **Lombok incluido pero no utilizado:** No hay modelos/DTOs en el proyecto actual que aprovechen sus anotaciones.

---

## 8. Información del Proyecto

| Campo | Valor |
|---|---|
| Group ID | `com.juanfedevmaster` |
| Artifact ID | `holamundo-webapp` |
| Versión | `0.0.1-SNAPSHOT` |
| Nombre | `holamundo-webapp` |
| Fecha de documentación | 30 de abril de 2026 |
