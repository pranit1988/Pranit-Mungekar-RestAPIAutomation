# REST Assured framework for Swagger Petstore - OpenAPI 3.0

-The automation framework project is created for a REST API, Swagger Petstore - OpenAPI 3.0. The tests are implemented using Rest Assured & build using Maven 
-The automation framework is built by automating the test cases mentioned in below section using REST assured and TestNG
-The solution uses Maven for build compilation & dependency management. Java faker library is used to generate random fake data wherever required.
	
Automation Test Cases for 3 API's:
---------------------------------

**Store API**
- To fetch the inventory status
- New order creation
- To Fetch the given order by ID
- To Delete newly created order

**Pet API**
- New pet creation
- To fetch all pets by statuses
- To find newly created pet by given id
- To update newly created by given id
- To update pet by form data

**User API**
- To fetch user details by username
- New user creation
- Log in the newly created user into the system
- Log out the newly created user from current active session	
	

- Follow instructions from the project's readme file

Setup Instructions (Windows)
----------------------

1. Download and install Eclipse IDE (https://www.eclipse.org/downloads/)
2. Clone this repo (Make sure you are on main branch):
```
https://github.com/pranit1988/Pranit-Mungekar-RestAPIAutomation.git
```
3. Import cloned repo in step 3 as Java project in Eclipse:
	- File->Import->Project from existing sources 
	- Choose 'PetstoreAPIProject' folder
4. Install Maven. Run following command in terminal -> ```brew install maven``` (Pre requisite: brew should be present in the system)
	
Run Automated Tests from IntelliJ / Terminal
----------------------
1. Navigate to 'PetstoreAPIProject' folder from terminal window
2. Run following command -> ``` mvn clean test```


Tools/Tech stack
----------------------
- REST-assured
- Maven
- Junit5
- Java
- Eclipse
- Git
- TestNG

Plan for further enhancement
----------------------
- To enhance framework for dynamic data creation
- Currently TestNG reports are generated but additional logger and extent/allure reports can be added.
- Dynamic data creation
