# Qualitest
Test - User adds 4 products to wishlist and out of those 4 products which ever is having minimum price gets added to cart and gets verified on Product Page 

For this test, tools used - selenium, cucumber and java.

To use this Repo you need to clone  - https://github.com/hansaasrani21/Qualitest.git
Once imported, please use commands
mvn clean
mvn test

Steps to run -
sr/test/java/com/runner/TestRunner.java - run TestRunner

Issues -
if you face issues due to currency, please replace pound symbol in src/test/ItemPage.java line number 103.