# Web Test Automation

This is a personal repository which I'll create a project using Selenium + Java in order to show my skills with test automation.

## Table of contents

- [About the project](#about-the-project)
- [Built with](#built-with)
- [Getting started](#getting-started)
  - [Prerequisites](#prerequisites)
- [Tests](#tests)

## About the project

This project is about the automation of a web page: http://opencart.abstracta.us/ using Selenium and Java.

![Web Site](/src/images/website.jpeg)

## Built With

This project is created with:

- Programming Language: Java
- Maven
- Selenium
- POM (Page Object Model)
- TestNG

## Getting started

## Prerequisites

Java/JDK must be installed on system. In order to check you can run this command to get the java version: `java -version`.

Download java and JDK links:

- JDK: https://www.oracle.com/java/technologies/downloads/#jdk17-mac-
- Java: https://www.java.com/en/download/

## Tests

```
Home Page:

- Verify that Home Page is displayed correctly
- Verify that when you open the home page the products are displayed, at least 1

Header Page:

- Verify that currency dropdown is displayed and once changed to $ currency , dropdown title is updated with the symbol of the selected currency and symbol of product prices change
- Verify that currency dropdown is displayed and once changed to € currency , dropdown title is updated with the symbol of the selected currency and symbol of product prices change
- Verify that currency dropdown is displayed and once changed to £ currency , dropdown title is updated with the symbol of the selected currency and symbol of product prices change

Register Page:

- Verify that create a new user is completed successfully
- Verify that error message is displayed when user click on continue button without filling all fields

Search Page:

- Verify that search is completed successfully
- Verify that search page title is showed
- Verify that each price is showed for all the products
- Verify that if you try to click 'Add to Wish List' without log in an error msg is showed

```
