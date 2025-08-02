&#x20;&#x20;

# Smart Expense Tracker

> A Spring Boot microservice to manage and visualize your personal expenses with ease.

**Author:** Ayush Singh
**Repository:** [SmartExpenseTracker](https://github.com/AyushSingh9930/SmartExpenseTracker)

---

## 🌟 Features

* **✅ User Authentication**: Secure JWT-based signup and login.
* **📊 Expense Management**: Create, read, update, delete expenses.
* **🔍 Advanced Filtering**: Query by date range, category, or amount.
* **🛑 Global Error Handling**: Uniform API error responses.
* **📜 API Documentation**: Interactive Swagger UI for exploration.
* **🔒 Secure**: Configurable CORS and password encryption.

## 📦 Built With

| Component      | Technology                  |
| -------------- | --------------------------- |
| **Language**   | Java 17                     |
| **Framework**  | Spring Boot 3.x             |
| **Security**   | Spring Security + JWT       |
| **Data Layer** | Spring Data JPA + Hibernate |
| **Database**   | MySQL                       |
| **Docs**       | Swagger (OpenAPI)           |
| **Build Tool** | Maven                       |

## 🚀 Getting Started

Follow these steps to get a development environment running:

### 1️⃣ Prerequisites

* Java 17 or later
* Maven 3.6+ (or use the Maven Wrapper)
* MySQL Server 8+ (or compatible)

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/AyushSingh9930/SmartExpenseTracker.git
cd SmartExpenseTracker
```

### 3️⃣ Configuration

Copy the example properties and update credentials:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Edit `application.properties`:

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/expenses?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_DB_PASSWORD

# JWT Settings
auth.jwt.secret=YourSecretKeyHere
auth.jwt.expiration=86400000  # 1 day in ms

# Server
server.port=8080
```

### 4️⃣ Build & Run

```bash
# Using Maven Wrapper
./mvnw clean package
java -jar target/SmartExpenseTracker-0.0.1-SNAPSHOT.jar

# Or via Maven
a mvn clean package
java -jar target/SmartExpenseTracker-0.0.1-SNAPSHOT.jar
```

The API will be available at `http://localhost:8080` and Swagger UI at `http://localhost:8080/swagger-ui.html`.

## 🚀 Usage

### Authentication

1. **Register**: `POST /api/v1/auth/register`
2. **Login**: `POST /api/v1/auth/login`

Include the returned `Bearer <token>` in the `Authorization` header for protected endpoints.

### Expenses API

| Endpoint                  | Method   | Description                    |
| ------------------------- | -------- | ------------------------------ |
| `/api/v1/expenses`        | `GET`    | List all expenses (secure)     |
| `/api/v1/expenses`        | `POST`   | Create a new expense           |
| `/api/v1/expenses/{id}`   | `GET`    | Retrieve expense details by ID |
| `/api/v1/expenses/{id}`   | `PUT`    | Update an existing expense     |
| `/api/v1/expenses/{id}`   | `DELETE` | Delete an expense              |
| `/api/v1/expenses/filter` | `POST`   | Filter expenses by criteria    |

#### Example: Create Expense

```bash
curl -X POST http://localhost:8080/api/v1/expenses \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "amount": 75.50,
    "category": "Groceries",
    "description": "Weekly grocery run",
    "date": "2025-08-01"
}'
```

---

Designed and built with ❤️ by Ayush Singh
