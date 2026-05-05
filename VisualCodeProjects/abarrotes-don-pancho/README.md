# Abarrotes Don Pancho - API REST

API REST para la gestión de clientes, productos y pedidos de la tienda **Abarrotes Don Pancho**, construida con Spring Boot 3 y PostgreSQL (Neon DB).

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 21 |
| Spring Boot | 3.5.14 |
| Spring Data JPA | (incluido en Boot) |
| Spring Data REST | (incluido en Boot) |
| PostgreSQL Driver | (incluido en Boot) |
| Lombok | (incluido en Boot) |
| Springdoc OpenAPI (Swagger) | 2.8.8 |
| Maven | Wrapper incluido |

---

## Requisitos previos

- Java 21+
- Maven 3.9+ (o usar el wrapper `./mvnw`)
- Acceso a la base de datos PostgreSQL en Neon DB

---

## Configuración

Las propiedades de conexión se encuentran en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://<host>/abarrotes_don_pancho?sslmode=require&channel_binding=require
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> **Recomendación de seguridad:** En producción, reemplaza los valores sensibles por variables de entorno:
> ```properties
> spring.datasource.password=${DB_PASSWORD}
> ```

---

## Estructura del proyecto

```
src/main/java/com/juanfedevmaster/abarrotedonpancho/
├── AbarrotesDonPanchoApplication.java   # Clase principal
├── entity/
│   ├── Cliente.java                     # Entidad tabla Clientes
│   ├── Producto.java                    # Entidad tabla Productos
│   └── Pedido.java                      # Entidad tabla Pedidos
├── repository/
│   ├── ClienteRepository.java
│   ├── ProductoRepository.java
│   └── PedidoRepository.java
├── service/
│   ├── ClienteService.java
│   ├── ProductoService.java
│   └── PedidoService.java
└── controller/
    ├── ClienteController.java
    ├── ProductoController.java
    └── PedidoController.java
```

---

## Modelo de base de datos

### Tabla `Clientes`

| Columna | Tipo | Restricción |
|---|---|---|
| `cedula` | VARCHAR(10) | PRIMARY KEY |
| `nombres` | VARCHAR(150) | NOT NULL |
| `apellidos` | VARCHAR(150) | NOT NULL |
| `celular` | VARCHAR(10) | NOT NULL |

### Tabla `Productos`

| Columna | Tipo | Restricción |
|---|---|---|
| `id` | INTEGER | PRIMARY KEY GENERATED ALWAYS AS IDENTITY |
| `name` | VARCHAR(150) | NOT NULL |
| `product_code` | VARCHAR(150) | NOT NULL |
| `price` | NUMERIC(2,0) | NOT NULL |
| `date_creation` | DATE | DEFAULT CURRENT_DATE |

### Tabla `Pedidos`

| Columna | Tipo | Restricción |
|---|---|---|
| `id` | BIGINT | PRIMARY KEY GENERATED ALWAYS AS IDENTITY |
| `cedula_cliente` | VARCHAR(10) | NOT NULL, FK → Clientes(cedula) |
| `fecha_pedido` | DATE | DEFAULT CURRENT_DATE |

---

## Ejecución

```bash
# Con Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Con Maven instalado
mvn spring-boot:run
```

La aplicación inicia en `http://localhost:8080`.

---

## Documentación interactiva (Swagger UI)

Disponible en:

```
http://localhost:8080/swagger-ui.html
```

---

## Endpoints de la API

### Clientes — `/api/clientes`

| Método | URL | Descripción | Body |
|---|---|---|---|
| GET | `/api/clientes` | Listar todos los clientes | — |
| GET | `/api/clientes/{cedula}` | Obtener cliente por cédula | — |
| POST | `/api/clientes` | Crear un cliente | JSON Cliente |
| PUT | `/api/clientes/{cedula}` | Actualizar un cliente | JSON Cliente |
| DELETE | `/api/clientes/{cedula}` | Eliminar un cliente | — |

**Ejemplo body POST/PUT:**
```json
{
  "cedula": "1234567890",
  "nombres": "Juan Felipe",
  "apellidos": "García López",
  "celular": "3001234567"
}
```

---

### Productos — `/api/productos`

| Método | URL | Descripción | Body |
|---|---|---|---|
| GET | `/api/productos` | Listar todos los productos | — |
| GET | `/api/productos/{id}` | Obtener producto por ID | — |
| POST | `/api/productos` | Crear un producto | JSON Producto |
| PUT | `/api/productos/{id}` | Actualizar un producto | JSON Producto |
| DELETE | `/api/productos/{id}` | Eliminar un producto | — |

**Ejemplo body POST/PUT:**
```json
{
  "name": "Arroz Blanquita",
  "productCode": "ARR-001",
  "price": 3500,
  "dateCreation": "2026-05-04"
}
```

---

### Pedidos — `/api/pedidos`

| Método | URL | Descripción | Body |
|---|---|---|---|
| GET | `/api/pedidos` | Listar todos los pedidos | — |
| GET | `/api/pedidos/{id}` | Obtener pedido por ID | — |
| GET | `/api/pedidos/cliente/{cedula}` | Listar pedidos de un cliente | — |
| POST | `/api/pedidos?cedula={cedula}` | Crear un pedido | JSON Pedido |
| PUT | `/api/pedidos/{id}?cedula={cedula}` | Actualizar un pedido | JSON Pedido |
| DELETE | `/api/pedidos/{id}` | Eliminar un pedido | — |

**Ejemplo body POST/PUT:**
```json
{
  "fechaPedido": "2026-05-04"
}
```

---

## Códigos de respuesta HTTP

| Código | Significado |
|---|---|
| 200 OK | Operación exitosa |
| 201 Created | Recurso creado exitosamente |
| 204 No Content | Eliminación exitosa |
| 400 Bad Request | Cliente no encontrado al crear/actualizar pedido |
| 404 Not Found | Recurso no encontrado |

---

## Compilar y empaquetar

```bash
./mvnw clean package
java -jar target/abarrotes-don-pancho-0.0.1-SNAPSHOT.jar
```
