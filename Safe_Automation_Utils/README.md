# Safe_WebElement_Utils
This library provides several different methods for interacting with WebElements using Selenium. In this library however the methods are
written in a way to make them "safe". This means that the methods try to catch any exceptions or errors and gracefully handle them so
that the front end user does not have to worry about their test application crashing due to an exception. 

An example of this is when trying to locate a WebElement, this library provides methods that will search for the WebElement and if it
cannot be found then null or false will be returned. Instead of having a NoSuchException exception thrown randomly during the test.

## Required Java  
Requires at least Java 1.8 to compile the source files.

## Library Dependencies  
Requires the following libraries to build successfully:
-Selenium 3.14
-Sikuli 1.1.4
-Apache Commons IO 2.6
-Apache POI 4.1.0
