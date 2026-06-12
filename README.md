# ElitePerformance – Corporate Bonus Management API 🚀

A secure and scalable **Spring Boot REST API** that automates employee performance evaluation and annual bonus calculation based on KPI scores for a multinational logistics company (GlobalSync).

---

## 📌 Project Overview

ElitePerformance system helps organizations:

* Evaluate employee performance using KPI metrics
* Automatically calculate total KPI score
* Assign performance categories (Gold, Silver, Bronze)
* Compute bonus and total compensation
* Secure data using Role-Based Access Control (RBAC)

---

## 🛠 Technologies Used

* Java
* Spring Boot
* Spring JDBC (NamedParameterJdbcTemplate)
* Spring Security
* MySQL
* Maven
* REST API Architecture

---

## 📊 KPI Evaluation Criteria

| KPI Criteria             | Max Points |
| ------------------------ | ---------- |
| Task Completion Rate     | 25         |
| Attendance & Punctuality | 15         |
| Team Collaboration       | 15         |
| Problem Solving Skill    | 15         |
| Communication Skill      | 10         |
| Leadership & Initiative  | 10         |
| Client Satisfaction      | 10         |
| **Total**                | **100**    |

---

## 🧮 KPI Score Formula

Total KPI Score =
Task Completion + Attendance + Team Collaboration + Problem Solving + Communication + Leadership + Client Satisfaction

---

## 🏆 Employee Categories

| Category    | Score Range | Bonus Percentage |
| ----------- | ----------- | ---------------- |
| Gold Tier   | 90 – 100    | 20%              |
| Silver Tier | 75 – 89     | 12%              |
| Bronze Tier | 60 – 74     | 5%               |
| No Tier     | Below 60    | 0%               |

---

## 💰 Bonus Calculation

**Bonus Amount Formula:**

Bonus = (Base Salary × Bonus %) / 100

**Total Compensation:**

Total Compensation = Base Salary + Bonus

### Example:

* Base Salary: 50,000 BDT
* KPI Score: 92
* Category: Gold Tier
* Bonus: 20%

👉 Bonus = 10,000 BDT
👉 Total Compensation = 60,000 BDT

---

## 🔗 API Endpoint

```http id="api123"
POST /api/performances/calculate
```

### Functionality:

* Accept KPI input
* Validate employee & scores
* Calculate total KPI score
* Determine category
* Calculate bonus
* Save performance review
* Save bonus record
* Return full response

---

## 🗄 Database Design

### Employees Table

* employee_id
* name
* designation
* base_salary
* role
* last_promotion_date

### Performance Reviews Table

* KPI scores (all parameters)
* total_kpi_score
* review_year
* employee_id

### Bonus Records Table

* bonus_id
* employee_id
* review_year
* category
* bonus_percentage
* bonus_amount
* total_compensation

---

## 🔐 Role-Based Access Control (RBAC)

| Role     | Permissions               |
| -------- | ------------------------- |
| EMPLOYEE | View own bonus records    |
| MANAGER  | Submit KPI reviews        |
| ADMIN    | View all employee bonuses |

---

## 🔄 Transaction Management

System ensures data consistency:

If any of the following fails:

* Performance review insert
* Bonus record insert
* Employee update

👉 Entire transaction is automatically rolled back.

---

## 📂 Project Structure

```
src/main/java/ElitePerformance/edu/
 │
 ├── controller/
 ├── dto/
 ├── entity/
 ├── repository/
 ├── service/
 ├── security/
 ├── EduApplication.java
```

---

## 📌 Key Features

* RESTful API design
* Automated KPI calculation
* Bonus automation system
* Secure RBAC system
* Spring JDBC integration
* Transaction management
* MySQL database support

---

## 🎓 Academic Information

**Course:** Advanced Programming with Java
**Semester:** Spring 2025–26
**Institution:** American International University-Bangladesh (AIUB)

---

## 👨‍💻 Developer

**Md Ridwan Bin Ahsan**

Computer Science & Engineering (CSE) – AIUB
