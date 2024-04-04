## **Project Description :**

This repository houses a comprehensive automation testing suite for Classicmodels database, built using Java, MySQL Connector, Maven, and TestNG. The suite aims to streamline the testing process by automating repetitive tasks and ensuring the website meet the desired standards.

 ## **Features :**

-**Maven**: Manages project dependencies and facilitates easy project setup and configuration.

-**TestNG**: Implements TestNG for efficient test case management and execution.

-**GitHub Actions Workflow**: Incorporates GitHub Actions to automate the build and execution process, ensuring seamless integration into the development workflow.

-**MySQL Connector**: MySQL Connector is a crucial component in testing the connection to a MySQL database. It is a library that enables user to connect and interact with MySQL databases using various programming languages.

## **Project Structure :**

the project structure is given below:

![Screenshot (33)](https://github.com/12gargi/DataBase-Testing/assets/97431292/d71ef153-9fc7-418f-ad40-34cd62117caa)

-**Project Contains :**

  1. BaseTest.java : this class is present in the src/main/java/source, it serves as a central component for managing MySQL connections in test classes. It encapsulates MySQL connection setup and teardown methods, providing a foundation for establishing database connections in test classes.


  2.  SchemaTests.java: this class is present in the src/test/java/schemaTesting, The class serves as a container for test cases focused on validating database schema integrity, structure, and consistency.


  3.  StoreProcedureTests.java: this class is present in the src/test/java/storeProcedureTesting, The class contains test cases focused on validating the functionality, performance, and correctness of stored procedures in the database.



  4.  TriggerTests.java:this class is present in the src/test/java/triggerTesting, The class contains test cases focused on validating the functionality, performance, and correctness of database triggers.


  5.  ManualTestcases : this is an excel file which contains all the manual testcases for store procedure and schema testing



  6.  mysqlsampledatabase: this folder contains classicmodels database ,store procedures , triggers and schemas.


## **Getting Started :**


To get started with the project, follow these steps:


**Clone the Repository:**

git clone:  https://github.com/12gargi/DataBase-Testing.git

**Install Dependencies :**  cd your_repository  ,
                          mvn clean install 

**Execute Tests:**           mvn test





