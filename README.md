# Tharun_ZurichAssessment_


# Maven Cucumber Selenium Demo Project

## Description
This is a **Maven-based** Java project that integrates **Cucumber** for behavior-driven development (BDD) testing and **Selenium WebDriver** for automating browser interactions. The project is built using **Java 16** and generates test reports using the **Cucumber Reports** plugin.

The project is designed to perform automated acceptance testing for web applications.

## Prerequisites
Ensure that the following tools are installed before proceeding with the setup:
- **Java 16** (or later) installed on your machine.
- **Maven** to manage project dependencies and build.
- **IDE** (such as IntelliJ IDEA or Eclipse) for Java development.

## Installation

1. Clone the repository
Clone this repository to your local machine:

git clone https://github.com/tharund1403/Tharun_ZurichAssessment_.git
cd maven-cucumber-selenium

2. Use Maven to install the project dependencies
mvn clean install

3. To run tests using Maven
mvn test
mvn test -Dcucumber.options="classpath:src/test/resources/features"

or To run tests using Test runner
Click on Run button in Test runner class with tags = "@Demo",

4. Reports
Test reports are available in the target/cucumber-reports directory.


