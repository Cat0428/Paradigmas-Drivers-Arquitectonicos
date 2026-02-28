# 🎟️ Event Registration System  
Arquitectura Backend basada en Drivers

Backend desarrollado con Spring Boot que gestiona inscripciones a un evento con cupo limitado, diseñado bajo principios de arquitectura limpia y control de concurrencia.

---

## 🚀 Tecnologías

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.3.5-brightgreen)
![Gradle](https://img.shields.io/badge/Build-Gradle-darkgreen)
![JUnit](https://img.shields.io/badge/Test-JUnit5-orange)

---

## 📌 Descripción

El sistema permite:

- Registrar participantes
- Cancelar inscripciones
- Consultar cupos disponibles
- Listar inscritos

El evento tiene un **cupo máximo de 5 participantes**.

El diseño se enfoca en garantizar:

- Seguridad bajo concurrencia
- Separación de responsabilidades
- Alta testabilidad
- Mantenibilidad

---

## 🏗️ Arquitectura

Se implementa una arquitectura en capas:

┌───────────────────────────────┐
│ Controller Layer │
│ (API REST) │
└───────────────▲───────────────┘
│
▼
┌───────────────────────────────┐
│ Service Layer │
│ (Lógica de negocio y reglas) │
└───────────────▲───────────────┘
│
▼
┌───────────────────────────────┐
│ Model Layer │
│ (Entidades del dominio) │
└───────────────────────────────┘

### 📂 Estructura del Proyecto

Paradigmas-y-Drivers-Arquitect-nicos
│
└── eventos
├── src
│ ├── main/java/com/arquitectura/eventos
│ │ ├── controller
│ │ ├── service
│ │ └── model
│ └── test
├── build.gradle


---

## 🎯 Drivers Arquitectónicos

### 🔹 Control de Concurrencia

**Problema:** múltiples solicitudes simultáneas pueden romper la regla de negocio.

**Solución:** uso de `ConcurrentHashMap` y operaciones atómicas (`putIfAbsent`) para prevenir race conditions.

Resultado: el sistema garantiza que nunca se superen los 5 cupos incluso bajo múltiples hilos concurrentes.

---

### 🔹 Separación de Responsabilidades

- El Controller maneja HTTP.
- El Service contiene reglas de negocio.
- El Model representa el dominio.

Esto permite:

- Bajo acoplamiento
- Fácil mantenimiento
- Pruebas unitarias independientes

---

### 🔹 Calidad y Validación

El sistema incluye pruebas unitarias que validan:

- Registro exitoso
- Prevención de duplicados
- Límite de cupo
- Cancelación
- Concurrencia multi-hilo

---

## 🔌 API REST

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | /api/inscripciones/registrar?nombre=Juan | Registrar participante |
| DELETE | /api/inscripciones/cancelar?nombre=Juan  | Cancelar inscripción |
| GET    | /api/inscripciones/cupos | Consultar cupos disponibles |
| GET    | /api/inscripciones/listar | Listar inscritos |

---

## ▶️ Ejecutar Proyecto

```bash
gradlew bootRun

Aplicación disponible en

http://localhost:8080

Ejecutar Pruebas

gradlew test


🔮 Posibles Mejoras Futuras

Integración con base de datos (JPA/Hibernate)

Documentación automática con OpenAPI

Dockerización

CI/CD

Despliegue en la nube

👨‍💻 Autor

Cristian David López Cardona
Software Engineering Student
Backend Development | Arquitectura de Software