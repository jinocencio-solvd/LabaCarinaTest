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

## Iter-3: Carina-Mobile(Android)

### Task
Requirements:
1. Create and automate test cases for Android application.

**Tested Android App:** [Sauce Labs Demo App](https://github.com/saucelabs/sample-app-mobile)

| Feature Owner (Author) | # | Name                    | Preconditions                                         | Step # | Description                                | Expected Result                               |
|:-----------------------|:---:|:--------------------------|:----------------------------------------|:------:|:-------------------------------------|:------------------------------------------|
| jinocencio-solvd       | 1 | Test Login              | App is opened in login screen                        | 1      | Click Username                             | Ability to enter text in the username field  |
|                        |   |                         |                                                       | 2      | Click Password                             | Ability to enter text in the password field  |
|                        |   |                         |                                                       | 3      | Click Login Button                         | User is redirected to the products page      |
| jinocencio-solvd       | 2 | Test Cart Count         | User is on products page                              | 1      | Click add to cart on one product           | Cart icon displays 1                         |
|                        |   |                         |                                                       | 2      | Click add to cart on another product       | Cart icon displays 2                         |
|                        |   |                         |  "n" is a number                                               | 3      | Click add to cart on "n" products          | Cart icon displays "n"                       |
| jinocencio-solvd       | 3 | Test Cart Has Products  | User is on products page and cart icon displays "n"   | 1      | Click cart button                          | User is redirected to cart page              |
|                        |   |                         |                                                       | 2      | Search through cart page for products in cart | Each product that accounts for "n" is present in the cart page |
| jinocencio-solvd       | 4 | Test Sort by Name (A to Z) | User is on products page                         | 1      | Click sort button                          | Ability to select sort preference is displayed |
|                        |   |                         |                                                       | 2      | Select Name (A to Z) button                | Sort preference is closed, and products page is displayed |
|                        |   |                         |                                                       | 3      | User is directed back to Products page     | Products are displayed in alphabetical order |
| jinocencio-solvd       | 5 | Test Sort by Name (Z to A) | User is on products page                         | 1      | Click sort button                          | Ability to select sort preference is displayed |
|                        |   |                         |                                                       | 2      | Select Name (Z to A) button                | Sort preference is closed, and products page is displayed |
|                        |   |                         |                                                       | 3      | User is directed back to Products page     | Products are displayed in reversed alphabetical order |
| jinocencio-solvd       | 6 | Test Sort by Price (Low to High) | User is on products page                  | 1      | Click sort button                          | Ability to select sort preference is displayed |
|                        |   |                         |                                                       | 2      | Select Price (Low to High) button          | Sort preference is closed, and products page is displayed |
|                        |   |                         |                                                       | 3      | User is directed back to Products page     | Products are displayed in ascending order by price |
| jinocencio-solvd       | 7 | Test Sort by Price (High to Low) | User is on products page                 | 1      | Click sort button                          | Ability to select sort preference is displayed |
|                        |   |                         |                                                       | 2      | Select Price (High to Low) button         | Sort preference is closed, and products page is displayed |
|                        |   |                         |                                                       | 3      | User is directed back to Products page     | Products are displayed in descending order by price |


## Iter-2: Carina-Web

### Task
Requirements:
1. Automate web scenarios using Carina and Page Object Pattern

**Tested Web Page:** [https://www.demoblaze.com/](https://www.demoblaze.com/)

| Feature owner (author) | # | Name                      | Preconditions                          | Step # | Description                          | Expected result                           |
|:-----------------------|:---:|:--------------------------|:----------------------------------------|:------:|:-------------------------------------|:------------------------------------------|
| jinocencio-solvd       | 1 | Test pagination Feature   | Page is opened and JS is loaded        | 1      | Products are loaded                 | Have an ability to click the next button |
|                        |   |                           |                                         | 2      | Click the next button              | Products displayed are different          |
|                        |   |                           |                                         | 3      | Click the previous button          | Products displayed are same as first paginated page |
| jinocencio-solvd       | 2 | Test categories filter    | "Products are loaded                   | 1      | Click category "Phones"            | Products displayed are only phones       |
|                        |   |                           | JS will load"                           | 2      | Click category "Laptops"           | Products displayed are only laptops      |
|                        |   |                           |                                         | 3      | Click category "Monitors"          | Products displayed are only monitors     |
| jinocencio-solvd       | 3 | Test Login                | User is not logged in                   | 1      | Click login button on Nav          | Login modal is displayed                  |
|                        |   |                           |                                         | 2      | Enter username                     | Username is entered in username field     |
|                        |   |                           |                                         | 3      | Enter password                     | Password is entered in password field     |
|                        |   |                           |                                         | 4      | Press modal login button           | Modal closes and username is displayed in Nav |
| jinocencio-solvd       | 4 | Test Logout               | User is logged in                      | 1      | Username is displayed in Nav       | Ability to click logout in Nav            |
|                        |   |                           |                                         | 2      | Click logout button in Nav         | Username is cleared from Nav              |
|                        |   |                           |                                         | 3      | Login feature restored             | User can log in                           |
| jinocencio-solvd       | 5 | Test Add To Cart          | "Products are loaded                   | 1      | Products are loaded                 | Ability to select a displayed product     |
|                        |   |                           | JS will load"                           | 2      | Click the title link of product    | User is redirected to the product page    |
|                        |   |                           |                                         | 3      | Product page is loaded              | "Add to cart" button is available         |
|                        |   |                           |                                         | 4      | Press select add to cart            | An alert is created                       |
|                        |   |                           |                                         | 5      | Accept alert                       | User remains on the product page          |
|                        |   |                           |                                         | 6      | Select cart button on nav bar         | User is redirected to the cart page       |
|                        |   |                           |                                         | 7      | Cart page is loaded                 | Selected product is displayed on cart page |

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

