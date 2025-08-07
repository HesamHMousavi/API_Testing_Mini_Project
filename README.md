# API_Testing_Mini_Project

### Which Endpoints Were Tested?
We have tested:
- **API 1:** GET all Products list
- **API 2:** POST to all products list
- **API 3:** GET all brands list
- **API 5:** POST to search product
- **API 6:** POST to search product without search product parameter
- **API 11:** POST to create/register user account
- **API 12:** DELETE method to delete user account
- **API 13:** PUT method to update user account
- **API 14:** GET user account detail by email

### How To Run The Tests?
- **Option 1:** Run Git Clone to clone the project into your IDE of choice, Check your Maven dependencies, Make a config properties file of your own as this is not commited to GitHub, Then run the tests.

- **Option 2:** Run this from the command line once downloaded:
  ```shell
  mvn clean test
  ```

### How To Add New Tests?
If users of this project wish to write some new tests, they will need to navigate to the test directory and add new test classes relating to what they want to test.

### Defects found.
We encounters a couple of problems that we consider to be defects while producing this project. Those include:
- **Status code mismatch:** Response code in HTTP level returns 200. Response code 400 was returned in body. This should not be there.
- **Returning HTML rather than JSON:** We all encountered a similar problem of the responses we were testing were returning as HTML rather than JSON

### Extra Info?
Every person that wishes to download and run our project must have thir own config file. As this contains sensitive data, it does not get committed to GitHub.
