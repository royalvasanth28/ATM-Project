# ATM Project (Java + MySQL)

## Overview
This is a simple **ATM simulation project** built using **Java** and **MySQL**. It allows users to:
- Check account balance
- Deposit money
- Withdraw money
- Print a receipt
- Register a new user

## Features
✅ User authentication using **User ID & PIN**  
✅ ATM menu with multiple operations  
✅ Database connectivity using **JDBC**  
✅ **HashMaps** for fast data retrieval  
✅ **SQL integration** to update account balances dynamically  

## Technologies Used
- **Java** (Core Java, Collections, JDBC)
- **MySQL** (Database management)
- **JDBC** (Java Database Connectivity)
- **Eclipse/IntelliJ** (IDE)

## Database Schema (MySQL)
```sql
CREATE DATABASE AtmProject;
USE AtmProject;

CREATE TABLE user (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    balance INT,
    pin INT
);

INSERT INTO user VALUES (1, 'Alice', 5000, 1234);
INSERT INTO user VALUES (2, 'Bob', 3000, 5678);
```

## How to Run the Project
1. **Clone the Repository**
```sh
git clone https://github.com/yourusername/AtmProject.git
```

2. **Set up MySQL Database**
- Create the database and table using the schema provided above.
- Update the **JDBC URL, username, and password** in `AtmProject.java`:
```java
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AtmProject","root","yourpassword");
```

3. **Compile and Run the Project**
```sh
javac AtmProject.java Atm_Process.java
java AtmProject
```

## Project Structure
```
AtmProject/
│-- src/
│   ├── AtmProject.java
│   ├── Atm_Process.java
│-- README.md
```

## Example Usage
```
Do you want to add new User...? (yes/no)
yes
Enter new User Name: John
Enter PIN for new User: 4321
Enter Initial Balance: 2000
```
```
Please select your bank user id:
1
Please Enter Your Pin:
1234
Welcome to SBI Atm...!!!
1. Check balance
2. Deposit money
3. Withdraw money
4. Print receipt
5. Exit
```

## Future Enhancements
 Implement a **Graphical User Interface (GUI)** using Java Swing or JavaFX  
 Add **transaction history tracking**  
 Integrate **secure encryption for PIN storage**  

## License
This project is open-source and available under the [MIT License](LICENSE).

