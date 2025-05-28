# RKSP — Spring Boot Backend API

Это веб-приложение на стеке **Java + Spring Boot + PostgreSQL**, реализующее REST API с авторизацией и CRUD-операциями для пользователей и встреч (meetings). 

##  Стек технологий

- Java 17+
- Spring Boot 3
- Spring Web (MVC)
- Spring Security
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose
- Lombok
# Как запустить
## 1. Запусти PostgreSQL
docker-compose up -d

## 2. Собери проект
./gradlew clean build

## 3. Запусти приложение
./gradlew bootRun
