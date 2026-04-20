# Trello API Test Automation Project
A lightweight Java‑based API automation project for testing Trello REST API.
Designed as a clean and simple framework suitable for learning, practice, and junior‑level portfolio projects.

## Overview
This project contains automated tests for Trello API using:

**Java 17**

**RestAssured**

**TestNG**

**Gradle**

The goal is to practice API testing, work with HTTP requests, and validate Trello functionality such as boards, lists, and cards.

---

## Objectives
- Learn and practice REST API automation
- Implement basic CRUD operations
- Build a simple and clean test structure
- Work with Trello authentication (API key + token)
- Validate responses and status codes

---  

## Project Structure
```
QA_50_32_Trello
│
├── src
│   └── test
│       └── java
│           ├── tests        # Test classes
│           ├── dto          # Request/response models
│           └── utils        # Helpers (config, endpoints)
│
├── build.gradle
├── gradle.properties
└── README.md
```

## Authentication
Trello API requires:
- API Key
- Token
You can generate them here:
https://trello.com/app-key

Store them in gradle.properties:

```
trello.key=YOUR_KEY
trello.token=YOUR_TOKEN
```
## Example Test
```
java
@Test
public void createBoardPositiveTest() {
    String boardId = BoardApi.createBoard("My Test Board");
    Assert.assertNotNull(boardId);
}
```
## How to Run Tests
1. Install dependencies
Java 17, Gradle, Internet connection

2. Run tests
```
gradle clean test
```
## Implemented Features
- Create board
- Delete board
- Basic response validation
- DTO‑based request/response models
- Simple reusable API methods

## Roadmap
- Add tests for lists
- Add tests for cards
- Add negative tests
- Add Allure reporting
- Add CI/CD (GitHub Actions)

## Author
Ilya Lapidus  
QA Automation Engineer
GitHub: https://github.com/IlyaQaTest
