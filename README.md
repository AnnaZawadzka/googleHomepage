# googleHomepage
Google project is a framework based on Selenium, Test NG and allure reporting

To open the project you need to have installed: 
1. Git 
2. Maven
3. JDK 1.8
4. Chrome, Geckodriver, IE drivers need to be added to locally
5. Chrome, Firefox, IE browsers relevant to downloaded drivers
path C:\driver

To run the tests: 
1. Clone repository
2. install project using command mvn install
3. To run specific test from cdm use command:
mvn clean test -Dsurefire.suiteXmlFiles=[test path] -Dexecution.environment=[environment name] -Dexecution.environment=[browser name]

example: 
mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/HomePageTestsRunner.xml -Dexecution.environment=PROD -Dexecution.environment=firefox

4. Second option is running test using xml file runners 