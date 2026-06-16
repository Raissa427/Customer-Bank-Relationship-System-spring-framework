# 🏦 CUSTOMER BANK RELATIONSHIP SYSTEM  
## Spring Framework Banking System

A comprehensive demonstration of Spring Framework's core features including **Dependency Injection (DI), Inversion of Control (IoC), and Aspect-Oriented Programming (AOP)** through a simple banking application.

---

# 📋 Project Overview

This Spring Framework banking system demonstrates how to convert a traditional Java application from manual object creation (`new`) to **Spring-managed dependency injection**.

The project showcases major Spring annotations working together in a real-world scenario, proving that `@Autowired` only works when objects are created and managed by Spring's `ApplicationContext`.

---

# 🎯 Key Learning Objectives

- 🔹 **Dependency Injection**  
  Understand how Spring injects dependencies automatically.

- 🔹 **IoC Container**  
  Learn how Spring manages object creation and lifecycle.

- 🔹 **AOP Logging**  
  See cross-cutting concerns in action with `@Before` and `@After`.

- 🔹 **Annotation-Driven Configuration**  
  Experience Spring's annotation-based configuration.

- 🔹 **Common Pitfalls**  
  Understand why `@Autowired` fails when using `new`.

---

# 🚀 Technologies Used

| Technology | Version / Purpose |
|------------|------------------|
| ☕ Java | 21 |
| 🌱 Spring Framework | 6.1.3 |
| 📦 Spring Context | Core, Beans, Context, SpEL |
| 🔄 Spring AOP | Aspect-Oriented Programming |
| ⚙️ AspectJ Weaver | AOP Implementation |
| 📋 Maven | Build & Dependency Management |

---

# 📁 Project Structure
src/main/java/com/igirepay/

├── Main.java
│ └── Application entry point
│
├── config/
│ └── AppConfig.java
│ └── Spring configuration (@Configuration)
│
├── service/
│ └── BankManager.java
│ └── Business logic (@Service)
│
├── model/
│ ├── Customer.java
│ │ └── Customer entity
│ │
│ ├── Account.java
│ │ └── Account entity
│ │
│ └── Transaction.java
│ └── Transaction entity
│
├── component/
│ └── TransactionLogger.java
│ └── Logging component (@Component)
│
└── aspect/
└── LoggingAspect.java
└── AOP logging (@Aspect)


---

# 🔧 Spring Annotations Used

| Annotation | Purpose | Applied To |
|------------|---------|------------|
| `@Configuration` | Marks class as Spring configuration | `AppConfig.java` |
| `@ComponentScan` | Scans for Spring components | `AppConfig.java` |
| `@EnableAspectJAutoProxy` | Enables AOP proxy support | `AppConfig.java` |
| `@Bean` | Creates Spring-managed beans | `AppConfig.java` methods |
| `@Service` | Marks business logic layer | `BankManager.java` |
| `@Component` | Marks Spring-managed component | `TransactionLogger.java` |
| `@Aspect` | Marks AOP aspect class | `LoggingAspect.java` |
| `@Autowired` | Injects dependencies automatically | `BankManager.java` fields |
| `@Qualifier` | Specifies which bean to inject | `BankManager.java` fields |
| `@Before` | Executes before target method | `LoggingAspect.java` |
| `@After` | Executes after target method | `LoggingAspect.java` |

---

# 💡 Key Features

## 1️⃣ Dependency Injection with `@Autowired`

Spring automatically injects dependencies into `BankManager` including:

- **TransactionLogger** → Logging component
- **Savings Account** → Selected using `@Qualifier`
- **Current Account** → Selected using `@Qualifier`
- **Default Customer** → Pre-configured customer bean

All dependencies are injected automatically without manual object creation.

---

## 2️⃣ Bean Configuration with `@Configuration` and `@Bean`

Spring beans are defined in the configuration class including:

- Two account beans (Savings and Current) with different balances
- A default customer bean
- Component scanning for automatic bean discovery

---

## 3️⃣ AOP Logging with `@Before` and `@After`

All banking operations are automatically logged:

- **@Before** → Logs method name and arguments before execution
- **@After** → Logs method completion after execution
- Cross-cutting concerns separated from business logic

---

## 4️⃣ The Critical Lesson: Why `@Autowired` Fails

The project demonstrates both the **WRONG** and **RIGHT** ways:

### ❌ WRONG WAY: Creating objects with `new` keyword

- `@Autowired` dependencies will be NULL
- Spring doesn't know about these objects
- Manual object creation bypasses Spring's IoC container


### ✅ RIGHT WAY: Getting objects from Spring's `ApplicationContext`

- `@Autowired` dependencies work correctly
- Spring manages the entire object lifecycle
- All dependencies are properly injected

---

📊 Expected Output

The application will display:

✅ Dependency Injection Verification
Shows all injected dependencies are NOT null, proving Spring injection works.
✅ Banking Operations
Customer registration, deposits, withdrawals, and transfers with AOP logging.
✅ AOP Logging
@Before and @After logs wrapping every operation.
✅ The Lesson
Clear demonstration of why new fails vs ApplicationContext succeeds.

# 📝 Key Takeaways
Never use new for Spring-managed classes — Always get beans from ApplicationContext.
@Autowired only works on Spring beans — Objects created with new won't have dependencies injected.
@Qualifier resolves ambiguity — Use it when multiple beans of the same type exist.
AOP adds cross-cutting concerns — Perfect for logging, security, and transactions.
Annotations reduce XML configuration — Cleaner and more maintainable code.
🛠️ Maven Dependencies

# The project uses the following Spring dependencies:

spring-context → Core Spring framework
spring-aop → AOP support
aspectjweaver → AOP weaving implementation
