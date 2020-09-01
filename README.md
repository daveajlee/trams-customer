# trams-customer

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ccb9bcbaafe64c7e9d37cacbf3bba7eb)](https://app.codacy.com/manual/dave_33/trams-customer?utm_source=github.com&utm_medium=referral&utm_content=daveajlee/trams-customer&utm_campaign=Badge_Grade_Dashboard)

This microservice for the TraMS platform stores customer feedback through REST and displays it to authorised individuals through a web client.

## How to use

1.  To use the microservice you need to specify the user specific configuration parameters in application.properties and application-production.properties. It is important in operators.list in application.properties to specify which operators should be available for use.
2.  Create an executable jar using mvn clean install.
3.  Run the jar (for example in production mode): java -Dspring.profiles.active=production -jar trams-customer.jar

### How to use the integrated Admin Client and Swagger

The microservice comes with an integrated admin client which allows you to view feedback which has already been submitted. This admin interface is available at <https://your-domain/trams-customer/admin/> The initial username and password is admin/admin.

You can save data to trams-customer through any language by calling the REST interface which is documented by Swagger and reachable through this URL:  <https://your-domain/trams-customer/swagger-ui.html>

### Available Profiles
*   local - This profile uses an in-memory database but does not use Eureka for service discovery. This works well for local development.
*   dev - This profile uses an in-memory database and Eureka for service discovery. This works well for development and testing.
*   production - This profile uses Eureka for service discovery and can be configured to use a database.
