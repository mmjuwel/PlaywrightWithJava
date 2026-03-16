# Playwright Java Automation Framework

A **modern UI Test Automation Framework** built with **Playwright**, **TestNG**, and **Apache Maven** using **Java OOP principles** and the **Page Object Model (POM)** design pattern.

The framework is designed for **scalability, maintainability, and enterprise CI/CD pipelines**.

----------

## Key Features

-   Page Object Model (POM) architecture
-   Clean **Java OOP based framework design**
-   **Data-Driven Testing** support
-   Advanced reporting with **Allure Report**
-   Detailed **execution logging**
-   **Automated Email Notification** after test execution
-   **Cross-browser testing** using Playwright
-   **CI/CD pipeline integration** with **Jenkins** and **GitHub Actions**
    



----------

## Framework Architecture

Test Layer (TestNG)  
 │  
 ▼  
Page Object Layer  
 │  
 ▼  
Utilities Layer  
(Browser, Config, Logger, Email)  
 │  
 ▼  
Playwright Engine  
 │  
 ▼  
Browser

----------

# #Project Structure

PlaywrightJavaAutomation  
│  
├── src  
│   ├── main  
│   │   ├── pages  
│   │   │   ├── BasePage.java  
│   │   │   ├── LoginPage.java  
│   │   │   └── DashboardPage.java  
│   │   │  
│   │   └── utilities  
│   │       ├── BrowserManager.java  
│   │       ├── ConfigReader.java  
│   │       ├── EmailUtil.java  
│   │       └── LoggerUtil.java  
│  
│   └── test  
│       ├── tests  
│       │   └── LoginTest.java  
│       │  
│       └── testdata  
│           └── loginData.xlsx  
│  
├── config  
│   └── config.properties  
│  
├── logs  
├── reports  
├── testng.xml  
└── pom.xml


## Execution
- Bash For Run TestNG suite
>    mvn test -DsuiteXmlFile=testng.xml

- Allure Report Generate and view report
 >    allure serve allure-results

- Execute cominely 
> mvn clean test -Dsurefire.suiteXmlFiles=testng.xml && allure serve target/allure-results

## Allure Report

![Allure Dashboard](https://github.com/mmjuwel/PlaywrightWithJava/blob/main/Images/Allure%20Dashboard.png)

![Allure Behavior](https://github.com/mmjuwel/PlaywrightWithJava/blob/main/Images/Behavior.png)



## Email Notification

![Email Notification](https://github.com/mmjuwel/PlaywrightWithJava/blob/main/Images/Email%20Notification.png)
