![Static Badge](https://img.shields.io/badge/DONE-%23009943?style=for-the-badge&logo=checkmarx&logoColor=%23FFF)

# MAIDS: Medical Assistance and Information Dissemination System

**Codename:** MAIDS
**Type:** Java Desktop App with MySQL (Student Project)  
**Created for:** Final Project in Object-Oriented Programming  
---

## 💡 Overview

**MAIDS (Medical Assistance and Information Dissemination System)** is a desktop application built using **Java Swing (NetBeans GUI Builder)** and **MySQL via phpMyAdmin** as the database. It was developed as a **final requirement for our Object-Oriented Programming course**, and it focuses on providing offline-accessible medical assistance for Filipinos who lack direct access to healthcare or are hesitant to seek help in person.

The project is functional but **not optimized** in terms of structure, naming conventions, or modularity — since the priority was to meet academic goals and showcase use of **Object Oriented Programming**.

---
## ⚠️ Note About Code Structure

> This project was built quickly using **NetBeans' drag-and-drop GUI**, resulting in a **messy file layout** and tightly coupled code. It's not production-level clean, but it works and demonstrates the required Java OOP and database skills.

---

## 🎯 Key Features

- **Symptom Checker:** Users enter symptoms and receive simple health tips pulled from the database.
- **Clinic Directory:** List of hospitals or clinics fetched from a MySQL database.
- **Checkup Recording:** Records all Check ups made by the doctor in charge
- **Simple Login Screen:** Basic user login (optional, for access control).

---

## 🧰 Tech Stack

- **Frontend:** Java Swing GUI (NetBeans drag-and-drop)  
- **Backend:** Java JDBC with MySQL  
- **Database:** MySQL (Accessed via phpMyAdmin)  
- **IDE:** NetBeans 12+  
- **Connector:** mysql-connector-java-x.x.x.jar

---

## 🔌 Setup Instructions

### Prerequisites:
- Java JDK 8 or higher  
- NetBeans IDE  
- XAMPP / MySQL (for phpMyAdmin)  
- MySQL JDBC Connector `.jar`

## 🛠 Installation & Setup

> ⚠️ Note: This project was built and tested on a Windows machine using XAMPP + NetBeans.

### 🔧 Prerequisites

- Java JDK 8 or higher
- NetBeans IDE
- XAMPP (Apache + MySQL)
- phpMyAdmin (optional GUI for DB setup)

### 🚀 Steps to Run

1. **Open the project in NetBeans**
   - Set your project package to: `package MAIDS;`
   - Right-click and **Clean and Build**

2. **Install and run XAMPP**
   - Start Apache and MySQL modules

3. **Create the Database**

   - Open `phpMyAdmin` or MySQL CLI
   - Run:
     ```sql
     CREATE DATABASE maids_database;
     USE maids_database;
     ```

4. **Create Required Tables**

   Use the following SQL scripts to manually set up the expected tables:

   ### ✅ Table 1: `patientaccounts`
   ```sql
   CREATE TABLE patientaccounts (
       PatientID VARCHAR(50) PRIMARY KEY,
       First_Name VARCHAR(50),
       Last_Name VARCHAR(50),
       Age INT
   );
   ```

   ### 👩‍🏫 Table 2: `accountdetails`
   ```sql
   CREATE TABLE accountdetails (
       accIDNumber VARCHAR(20) PRIMARY KEY,
       accFull_Name VARCHAR(100),
       accPassword VARCHAR(50)
   );
   ```

   ### 👩‍💻 Table 3: `admin`
   ```sql
   CREATE TABLE admin (
       admin_id VARCHAR(20) PRIMARY KEY,
       admin_name VARCHAR(100),
       admin_password VARCHAR(50)
   );
   ```

   ### 📋 Table 4: `system_logs`
   ```sql
   CREATE TABLE system_logs (
       log_id INT AUTO_INCREMENT PRIMARY KEY,
       log_action VARCHAR(100),
       log_by VARCHAR(100),
       log_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```
---

## 🔒 DB Config (Edit as needed)

Inside your Java classes, make sure the connection parameters match your local setup:

```java
private static final String DBname = "maids_database";
private static final String DBurl = "jdbc:mysql://localhost:3306/" + DBname;
private static final String DBIDNumber = "root";
private static final String DBPassword = ""; // default for XAMPP
```

## ✍️ License

This project was for educational use only — feel free to improve or reuse for academic purposes.

## 🙃 Notes from the Devs

> - "The code structure is *ugly* — compliance lang to pass OOP finals!"
> - "We were students, okay 😭"
> - "Still proud it worked from end to end!"

## 👨‍💻 Developers

- **Rafhielle Allen Alcabaza**
- **Sean Paul Nieves**
- **Rovic Christopher Sarthou**
- **Breindelle Vincent Ayuso**

> *All four helped build this in OOP class for survival, stress, and grades.*
