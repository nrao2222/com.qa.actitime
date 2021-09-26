# com.qa.actitime
Actitime Automation Framework

Hybrid Framework: combination of Data driven with Page Object Model and Page Factory

Extent reporting for executing reports

TestNG to execute the framework as a suite

Maven as the build tool

Framework Design:

  Component I - Base package contains WebDriver components
  
  Compnent II - Pages package contains each page within the AUT such as Login Page, Home Page, Tasks Page
  
  Component III - Utils package contains ExcelReader and Helper classes to read test data from an Excel file and to take screen shots in case of test failure.
  
  Component IV - Testcase package contains tests for various scenarios such as Login, Invalid Login, Create Customer, Delete Customer etc
