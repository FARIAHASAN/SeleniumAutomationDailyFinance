# Project Title: POM-Based Selenium Automation for a financial management website
## Project Summary:This project demonstrates an end-to-end automation framework for a web application, DailyFinance(https://dailyfinance.roadtocareer.net/), using Selenium with Java. It follows best practices, including the Page Object Model (POM) design pattern, and integrates dynamic data handling with JSON and CSV files. 
The framework includes both smoke and regression testing suites and produces detailed Allure reports.
## Technology Stack:
- Selenium with Java: For web application automation.
- TestNG: For managing test execution and suites.
- Gradle: For build and dependency management.
- Allure: For generating insightful test reports.

## How to run?
### Execute following commands:
- ``` git clone  https://github.com/FARIAHASAN/SeleniumAutomationDailyFinance.git ```

## Automated Test Scenarios:

## User Registration:
- Registered users with all fields filled.
- Registered users with only mandatory fields.
- Attempted registration without mandatory fields.
- Verified results using assertions and stored user data in a JSON array.
## Admin Verification:
- Logged in as admin with credentials passed via the terminal.
- Verified that the last registered user appears on the admin dashboard.
- Printed and validated the user's first name, email, and phone number against JSON data.
## Profile Update:
- Logged in as the last registered user and successfully updated their profile image.
## Cost Management:
- Added multiple expenditures using data from a CSV file.
- Looped through 5 records to add items with attributes like name, amount, quantity, purchase date, and remarks.
- Verified the total expenditure against the expected sum.
## Search and Validation:
- Searched for an item by name.
- Verified the displayed total cost matches the expected price for the item.
## Suite Execution:
## Created separate test suites:
- Regression Suite: Comprehensive testing of all scenarios.
- Smoke Suite: Focused testing of high-priority functionalities (cost management and search).
## Reporting:
Generated Allure reports for regression tests, providing detailed insights into test execution results.

## Output:
![Screenshot 2024-12-11 230654](https://github.com/user-attachments/assets/09ffceaa-85d2-42ad-8293-e4cdbcdf5726)
![Screenshot 2024-12-11 230628](https://github.com/user-attachments/assets/3bbb98ac-f11e-4e5d-9823-cc5a5a048571)

## Video Documentation:
https://github.com/user-attachments/assets/6946af5a-b944-430b-894a-3ffed68152b3
