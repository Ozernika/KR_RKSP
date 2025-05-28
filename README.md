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
##  Структура проекта
rksp/
│
├── src/
│ ├── main/
│ │ ├── java/com/example/rksp/
│ │ │ ├── controller/ # REST-контроллеры (UserController и др.)
│ │ │ ├── model/ # JPA-сущности (AuthUser и др.)
│ │ │ ├── repository/ # Интерфейсы для работы с базой (UserRepository и др.)
│ │ │ ├── service/ # Бизнес-логика, включая UserService (UserDetailsService)
│ │ │ └── security/ # Конфигурация Spring Security
│ │ └── resources/
│ │ ├── application.properties # Конфигурация приложения (или .properties)
│ │ └── ...
│ └── test/ # Unit и Integration тесты
│
├── docker-compose.yml # PostgreSQL контейнер
├── build.gradle # Сборка Gradle
└── README.md # Документация проекта
## Как запустить
# 1. Запусти PostgreSQL
docker-compose up -d

# 2. Собери проект
./gradlew clean build

# 3. Запусти приложение
./gradlew bootRun
