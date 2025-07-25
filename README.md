
# 🛒 Rokomari.com Web Automation Project

This is my first end-to-end **Web Automation Testing Project** using **Selenium WebDriver**, implemented with the **Page Object Model (POM)** design pattern. The automation test simulates a complete shopping flow on [Rokomari.com](https://www.rokomari.com/), from login to checkout and logout.

---

## 📌 Project Overview

**Tech Stack:**

- Language: Java
- Build Tool: Maven
- Testing Framework: TestNG
- Automation Tool: Selenium WebDriver
- Design Pattern: Page Object Model (POM)
- Reporting Tool: Allure Report
- Browser Support: Chrome, Edge, Firefox (via WebDriverManager)

---

## ✅ Test Scenarios Covered

1. **Invalid Login Attempt**
2. **Valid Login with Credentials**
3. **Author Selection & Book Filtering**
4. **Add to Cart & Cart Verification**
5. **Checkout Process**
6. **Shipping Address Input**
7. **Logout Process**

---

## 📁 Project Structure (POM)

```
rokomari-automation/
├── pages/
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── BookPage.java
│   ├── CardPage.java
│   └── ShippingPage.java
├── testcases/
│   └── AllTestPages.java
├── utilities/
│   └── DriverSetup.java
├── pom.xml
└── README.md
```

---

## 🧪 Allure Test Report

After test execution, the test results are captured and visualized using Allure Reporting.

**To Generate Allure Report:**
```bash
allure generate allure-results --clean -o allure-report
allure serve allure-results
```

📸 Sample Report Screenshot:
> (Screenshot upcoming)  
> ![Allure Report](https://github.com/Md-Ashikujjaman/rokomari-automation/blob/main/images/Allure_Report.PNG)
> ![Allure Report Suites](https://github.com/Md-Ashikujjaman/rokomari-automation/blob/main/images/Suites.PNG)
> ![Allure Report Graph](https://github.com/Md-Ashikujjaman/rokomari-automation/blob/main/images/Graph.PNG)
> ![Allure Report Packages](https://github.com/Md-Ashikujjaman/rokomari-automation/blob/main/images/Packages.PNG)

---

## 🔄 How the Flow Works

1. Launch Browser
2. Navigate to Home Page
3. Close any popup (if visible)
4. Login with provided credentials
5. Navigate to "Book" Menu → Select Author (e.g., হুমায়ূন আহমেদ)
6. Apply filters (e.g., category: সমকালীন উপন্যাস)
7. Add book to cart
8. Proceed to checkout
9. Fill shipping details
10. Confirm order
11. Logout

---

## 🧑 Author

**Md. Ashikujjaman**  
SQA Engineer | Test Automation Enthusiast  
📧 Email: [ashik35uap@gmail.com](mailto:ashik35uap@gmail.com)  
🔗 [LinkedIn Profile](https://www.linkedin.com/in/mdashikujjaman/)  
📦 [GitHub Projects](https://github.com/Md-Ashikujjaman/)

---

## 📌 Note

- Credentials used in this project are for testing purpose only.
- The project is designed and implemented for educational and portfolio presentation.

---

## 📷 Project Preview (Upcoming)

> Sample test run screenshots, login page, cart page, and Allure dashboard.

---

## 🚀 Run the Test

```bash
# Run tests with TestNG
mvn clean test
```

```bash
# Generate Allure Report
allure generate allure-results --clean -o allure-report
allure serve allure-results
```

---

## 🌟 What I Learned

- Selenium WebDriver fundamentals
- TestNG for test lifecycle management
- Page Object Model for test scalability
- Handling popups, dropdowns, and dynamic elements
- End-to-End Automation flow
- Allure report integration

---
