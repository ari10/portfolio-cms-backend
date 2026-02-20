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

## 👤 Profile API

### Update Profile (Auth Required)

```
PUT /api/profile
```

### Get Profile (Public)

```
GET /api/profile/{username}
```

---

## 💼 Project API

### Create Project (Auth Required)

```
POST /api/projects
```

### Get Projects (Public + Pagination)

```
GET /api/projects/{username}?page=0&size=10
```

### Update Project

```
PUT /api/projects/{id}
```

### Delete Project

```
DELETE /api/projects/{id}
```

---

## 🖼️ Upload API

### Upload Image

```
POST /api/upload
```

* Content-Type: `multipart/form-data`
* Key: `file`

Response:

```
{
  "data": "http://localhost:8080/uploads/filename.png"
}
```

---

## ⚙️ Setup & Run

### 1. Clone repo

```
git clone https://github.com/your-username/portfolio-cms-backend.git
```

### 2. Setup database (PostgreSQL)

Update `application.yml`:

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/portfolio_cms
    username: your_user
    password: your_password
```

### 3. Run project

```
./gradlew bootRun
```

---

## 🔥 Future Improvements

* Cloud storage (AWS S3 / Cloudinary)
* Role-based authorization
* Docker deployment
* CI/CD pipeline
* Frontend (Vue.js admin dashboard)

---

## 👨‍💻 Author

Built by [Your Name]

---

## ⭐ Notes

This project is part of a mini SaaS portfolio system and can be extended into a full product.
