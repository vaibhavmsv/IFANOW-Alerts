# IFANOW-Alerts

Make sure to have java and maven installed. 

Perform below commands to run this project:
1. mvn install -DskipTests
2. mvn exec:java - this will get the server started in 8080 port. Hit below POST request in postman/browser for event processing.

"http://localhost:8080/myapp/myresource?userId=2&eventTime=20170315 134850&timeSpent=11&properties={"bank":"idb","merchantId":237, "value":142.5, "mode":"netbank"}"


