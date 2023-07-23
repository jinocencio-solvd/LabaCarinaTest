# LabaCarinaTest

## About This Project:

This repository serves as a demonstration of the Carina Automation Framework, a powerful tool built
on top of popular open-source solutions such as Selenium, Appium, and TestNG. Carina is designed to
automate and streamline the testing process for web applications, reducing dependence on a specific
technology stack. By leveraging the Selenium WebDriver, Carina enables efficient interaction with
web elements, ensuring effective testing and validation of web-based systems.

#### Continuous Integration (CI)

This project utilizes Github Workflows for continuous integration (CI), which automates the process
of building and testing the Java Maven package. Whenever there are code changes pushed to the
repository or a pull request is submitted, GitHub Actions is triggered to execute tests and verify
that the code functions correctly. Successful builds and tests are marked with a :white_check_mark:
next to the commit ID, while failed builds or tests are indicated with :x:.

The tests are organized into test suites and make use of various Carina dependencies. They can be
found in the src/test/java/ directory. By implementing automated testing, we can identify and
address issues early in the development cycle, ensuring that our code consistently meets the
expected standards. This approach helps to maintain code quality and ensures the project remains
stable and reliable.

## Iter-1: Carina-API

### Task

Requirements:

1. Automate API tests using Carina (cover flows similar to ones presented in sample Carina tests)
    - 5 tests
    - Do different http methods

   The Carina-API dependency was demonstrated against api calls to `https://dummyjson.com`.
    - Implemented HTTP methods are `DeleteProductMethod`, `GetAllProductsMethod`
      , `GetOneProductMethod`, `PostProductMethod` and `PutProductMethod`.
    - Tests are implemented in `test/java/APITest`
        - Both `testGetOneProduct` and `testGetAllProducts` takes advantage
          of `validateResponseAGainstSchema` to validate the response object.
        - A properties file is used in `testPostProductsWithProperties` for configuration management
          of API request arguments, `validateResponse` was used to compare expected response with
          actual response.
        - Parsing the response object was used in `testPostProductContent` to verify specific
          element values.
        - Making use of `FreeMarker` was demoed in the expected response object `post/res.json`
          which was tested in `testPostProductsWithPropertiesMissingField`. This was performed by
          removing configurations in the Properties file
        - Both `testPutProducts` and `testDeleteProducts` verifies an HTTP 200 OK status code and
          validates the response object to indicate a passing test

