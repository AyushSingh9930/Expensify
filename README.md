&#x20;&#x20;

# Smart Expense Tracker

> A beautifully designed Spring Boot microservice to manage and visualize your personal expenses with ease.

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

### 🔐 Authentication Endpoints

| Endpoint                 | Method | Description                  |
| ------------------------ | ------ | ---------------------------- |
| `/api/v1/users/register` | POST   | Register a new user          |
| `/api/v1/users/login`    | POST   | Authenticate and receive JWT |

### 💸 Expense Endpoints

| Endpoint                      | Method | Description                                  |
| ----------------------------- | ------ | -------------------------------------------- |
| `/api/v1/expense/add`         | POST   | Add a new expense                            |
| `/api/v1/expense/by-username` | GET    | List expenses for the authenticated user     |
| `/api/v1/expense/update/{id}` | PUT    | Update an existing expense by ID             |
| `/api/v1/expense/filter`      | POST   | Filter expenses by date, category, or amount |
| `/api/v1/expense/delete/{id}` | DELETE | Delete an expense by ID                      |

### 🛡️ Admin Endpoints

| Endpoint                    | Method | Description              |
| --------------------------- | ------ | ------------------------ |
| `/api/v1/admin/delete/{id}` | DELETE | Delete a user by user ID |

#### Example: Add Expense

```bash
curl -X POST http://localhost:8080/api/v1/expense/add \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "amount": 75.50,
    "category": "Groceries",
    "description": "Weekly grocery run",
    "date": "2025-08-01"
}'
```

## 🧪 Testing

Run all tests with:

```bash
./mvnw test
```

Run all tests with:

```bash
./mvnw test
```

## 🤝 Contributing

1. Fork this repository
2. Create a feature branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature-name`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

---

Designed and built with ❤️ by Ayush Singh
