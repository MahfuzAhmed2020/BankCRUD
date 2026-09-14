# BankCRUD

Simple Spring Boot CRUD application with MySQL, Docker, and static HTML UI.

## Ports

- Spring Boot: 8099
- MySQL host port: 3309
- MySQL container port: 3306

## Requirements

- Java 21
- Maven
- Docker Desktop

## Run

```powershell
mvn clean package -DskipTests
docker compose up --build
```

Open:

http://localhost:8099

## API

- POST http://localhost:8099/api/accounts
- GET http://localhost:8099/api/accounts
- GET http://localhost:8099/api/accounts/1
- PUT http://localhost:8099/api/accounts/1
- DELETE http://localhost:8099/api/accounts/1

## MySQL

```powershell
docker exec -it bankcrud-mysql mysql -uroot -proot
```

```sql
USE bankcrud;
SHOW TABLES;
SELECT * FROM bank_account;
```

## Stop

```powershell
docker compose down
```

Delete database data too:

```powershell
docker compose down -v
```
