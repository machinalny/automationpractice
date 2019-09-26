# automationpractice
Page Object Pattern on automationpractice.com

## Description.
TAF is based on PageObject Pattern in JAVA with Selenium. 
There is a one test in Smoke Test which creates 5 new users, test is parametrized.
To provide data a https://mockaroo.com is used with predefine schema.
To map web pages TAF use support of a PageFactory.

### Next?
1. Map all pages of the with cache and getters setters.
2. Create exceptionHandler.
3. Add more tests like Log in, add product to basket, buy product
4. Add Actions -> When buying products this is needed because of hover actions.
5. Provide more data if there is a possibility with a usage of a system db.

## Project structure.
automationpractice
│   pom.xml
│   testng.xml    
│   readme.MD
|
└───java
    |
    └───com.machinalny.automationpractice
        |
        └───component
            |
            | Repeatable components of HTML Pages
        |
        └───page
            |
            | Page Objects
        |
        └───testcase
            |
            | Test Cases
        |
        └───utils
            |
            | Extra utility classes
            



## How to run.
* You need to have a maven in your path.
* Go to the main directory e.g. `/your_computer/automationpractice/`
* Execute tests by: `mvn -Dtest=SmokeTest test`
