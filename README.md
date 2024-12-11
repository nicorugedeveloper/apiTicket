
# README

## Inicialización del Proyecto Localmente
Este documento describe los pasos para inicializar el proyecto en un entorno local usando Docker, junto con las URLs disponibles y las estructuras JSON necesarias para interactuar con la aplicación mediante Postman.

---

### 1. Configuración del Proyecto con Docker

#### Requisitos previos:
- Docker instalado en su sistema.
- Docker Compose instalado.

#### Pasos:
1. Clonar el repositorio del proyecto en su máquina local:
   ```bash
   git clone https://github.com/nicorugedeveloper/apiTicket.git
   ```
   ```bash
   cd PruebaTecnica
   ```

2. Construir la imagen de Docker usando el `Dockerfile`:
   ```bash
   docker build -t prueba-tecnica .
   ```

3. Levantar los servicios usando Docker Compose:
   ```bash
   docker-compose up -d
   ```

4. Verificar que el contenedor esté corriendo:
   ```bash
   docker ps
   ```

---

### 2. URLs para Postman

Los siguientes endpoints están disponibles en la aplicación:

- **Tickets**:
  - `POST /api/tickets`: Crear un nuevo ticket.
  - `GET /api/tickets?page={numero}&size={numero}`: Obtener todos los tickets. (Se debe especificar la pagina y la cantidad de items que se quieran traer quitando los corchetes y remplazando la palabra numero por el valor que desee)
  - `GET /api/tickets/{id}`: Obtener un ticket por ID.
  - `GET /api/tickets/status/{status}`: Obtener tickets por estado. (Este estatus debe ser entre ABIERTO, CERRADO. Respando las mayusculas)
  - `PUT /api/tickets/{id}`: Actualizar un ticket por ID.
  - `DELETE /api/tickets/{id}`: Eliminar un ticket por ID.

- **Integración con GitHub**:
  - `GET /api/user-profiles/search?name={nombre}`: Obtener información de un usuario de GitHub. 

---

### 3. Estructuras JSON para Postman

#### Crear Ticket (`POST /api/tickets`)
```json
{
  "usuario": "Nombre del usuario",
  "status": "Tipo de estatus: ABIERTO o CERRADO",
}
```

#### Actualizar Ticket (`PUT /api/tickets/{id}`)
```json
{
  "usuario": "Cambio de nombre",
  "status": "Cambio de estatus"
}
```

#### Respuesta de Ticket (`GET /api/tickets/{id}`)
```json
{
  "id": 2,
    "usuario": "Juan",
    "fechaCreacion": "2024-12-11T09:11:30.429182",
    "fechaActualizacion": "2024-12-11T09:11:30.429182",
    "estatus": "ABIERTO"
}
```

#### Perfil de Usuario (`GET /api/user-profiles/search?name={nombre}`)
```json
{
  {
            "login": "johanhelsing",
            "id": 2620557,
            "url": "https://api.github.com/users/johanhelsing",
            "type": "User",
            "score": 1.0,
            "node_id": "MDQ6VXNlcjI2MjA1NTc=",
            "avatar_url": "https://avatars.githubusercontent.com/u/2620557?v=4",
            "gravatar_id": "",
            "html_url": "https://github.com/johanhelsing",
            "followers_url": "https://api.github.com/users/johanhelsing/followers",
            "following_url": "https://api.github.com/users/johanhelsing/following{/other_user}",
            "gists_url": "https://api.github.com/users/johanhelsing/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/johanhelsing/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/johanhelsing/subscriptions",
            "organizations_url": "https://api.github.com/users/johanhelsing/orgs",
            "repos_url": "https://api.github.com/users/johanhelsing/repos",
            "events_url": "https://api.github.com/users/johanhelsing/events{/privacy}",
            "received_events_url": "https://api.github.com/users/johanhelsing/received_events",
            "site_admin": false
        }
    ],
    "total_count": 47416,
    "incomplete_results": false
}
```
---

### Notas Adicionales
- Asegúrese de que los puertos necesarios (por defecto: 8080) estén disponibles en su máquina local.
- Puede modificar el archivo `application.properties` en `src/main/resources` para configurar parámetros adicionales, como la conexión a bases de datos o claves API.
