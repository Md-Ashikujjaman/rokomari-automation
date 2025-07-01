
# Rokomari Automation Project

This is a practice web automation project for testing the core shopping flow of [Rokomari.com](https://www.rokomari.com/) using **Selenium WebDriver**, **Java**, **JUnit**, and **Maven**.

---

## 🧪 Test Scenario

The test simulates a user shopping on Rokomari. It includes:

1. Sign Up using Google
2. Select লেখক (Authors) from the main menu
3. Select "হুমায়ুন আহমেদ" as the author
4. Apply filters: 
   - সমকালীন উপন্যাস  
   - রচনা সংকলন ও সমগ্র
5. Scroll to the bottom and go to the next page (if available)
6. Add a book to the cart
7. View the cart
8. Proceed to checkout
9. Provide shipping information (manually or via automation)
10. Log out

---

## 🛠 Tech Stack

- **Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Testing Framework:** JUnit 5
- **Build Tool:** Maven
- **Browser:** Chrome

---

## 📁 Project Structure

```
rokomari-automation/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/pages/
│   │   ├── LoginPage.java
│   │   ├── AuthorPage.java
│   │   ├── BookPage.java
│   │   └── CartPage.java
│   └── test/java/
│       ├── BaseTest.java (optional)
│       └── RokomariFlowTest.java
```

---

## ▶️ How to Run

1. **Clone this repo**
   ```bash
   git clone https://github.com/your-username/rokomari-automation.git
   cd rokomari-automation
   ```

2. **Ensure you have:**
   - Java JDK 17+
   - Maven
   - Chrome browser installed
   - ChromeDriver in your system PATH

3. **Run the test using Maven**
   ```bash
   mvn test
   ```

---

## ⚠️ Notes

- Google Sign-In requires handling popup windows. You can skip or mock this step if you face automation restrictions.
- Rokomari may change their site structure. Update XPaths and locators accordingly.
- If you're filling shipping information, add dummy input fields handling in `CartPage.java`.

---

## 📌 Author

**Md. Ashikujjaman**  
Automation Tester | Learning QA Engineering  
[LinkedIn](#) | [GitHub](https://github.com/your-username)

---

## 📃 License

This project is for **educational and practice purposes only**. Not affiliated with Rokomari.com.
