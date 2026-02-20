# 🚀 Portfolio CMS Backend

A backend API for a developer portfolio CMS built with **Kotlin + Spring Boot**.
This project allows users to manage their portfolio (profile & projects) and serves public portfolio data.

---

## 🧠 Features

* 🔐 JWT Authentication (Register & Login)
* 👤 Profile Management (Create & Update)
* 💼 Project CRUD (Create, Read, Update, Delete)
* 🌍 Public API (Access portfolio by username)
* 🖼️ Image Upload (Local storage)
* 📄 Pagination for projects
* ✅ Request Validation
* ⚠️ Global Exception Handling
* 📦 Clean Architecture (feature-based structure)

---

## 🛠️ Tech Stack

* Kotlin
* Spring Boot
* Spring Security (JWT)
* Spring Data JPA
* PostgreSQL
* Gradle

---

## 📁 Project Structure

```
com.example.backendcms
├── auth        # Authentication & JWT
├── user        # User entity & repository
├── profile     # Profile feature
├── project     # Project feature
├── common      # Shared (response, exception, upload)
├── config      # Security configuration
```

---

## 🔐 Authentication

### Register

```
POST /auth/register
```

### Login

```
POST /auth/login
```

Response:

```
{
  "token": "JWT_TOKEN"
}
```

---

## 👤
