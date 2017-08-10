# hivery_assignment
Hivery Java Backend Demo

Developer : Suresh Pritmani
Date : 10-August-2017

Project : Demo for HIVERY JAVA BACKEND ASSIGNMENT
TECHNOLOGY : SPRING BOOT, SPRING CORE, SPRING REST, JPA-HIBERNATE, MySQL, JACKSON, MAVEN

HOW TO START:
- Clone the application
- Start application from java main class - StartApplication.java

As this is spring boot application, the main class is StartApplication.java which will boot the application.
This class contains a method "convert", which can be used to parse the json files (stored in resource folder) from the application.
Once data loaded, following Rest URLs can be performed.

As per the configuration in application.properties file, DB will be automatically created in MySQL database and data will be loaded on startup.
Database Name : assignments
The property name is "spring.jpa.hibernate.ddl-auto".
It is marked as "create" which can be used to create the database.


====================================================================================================
Problem 1 : Given a company, the API needs to return all their employees. Provide the appropriate solution if the company does not have any employees.
Rest LINK : http://localhost:8080/paranuara/listOfEmployee/company/{name}
Description : In above Rest URL, {name} is "company" field from company.json

Example 1 : http://localhost:8080/paranuara/listOfEmployee/company/PERMADYNE
Output : {"Employees of PERMADYNE":["Frost Foley","Luna Rodgers","Boyer Raymond","Solomon Cooke","Walter Avery","Hester Malone","Arlene Erickson"]}

Example 2 : http://localhost:8080/paranuara/listOfEmployee/company/NETBOOK
Output : {"Message":"No Employees Associated with NETBOOK"}

====================================================================================================
Problem 2 : Given 2 people, provide their information (Name, Age, Address, phone) and the list of their friends in common which have brown eyes and are still alive.
Rest LINK : http://localhost:8080/paranuara/people/commonFriends/{id1}/{id2}
Description : In above Rest URL, {id1} and {id2} are "index" field from people.json

Example 1 : http://localhost:8080/paranuara/people/commonFriends/884/985
Output : {"People Two":{"Address":"821 Coventry Road, Manchester, New Mexico, 2751","Phone":"+1 (878) 521-3781","Age":46,"Name":"Arlene Erickson"},"Common Friends":["Decker Mckenzie","Mindy Beasley","Whitfield Deleon"],"People One":{"Address":"545 Calyer Street, Bangor, North Dakota, 4963","Phone":"+1 (820) 530-2031","Age":50,"Name":"Stephanie Herrera"}}

====================================================================================================
Problem 3 : Given 1 people, provide a list of fruits and vegetables they like. This endpoint must respect this interface for the output: {"username": "Ahi", "age": "30", "fruits": ["banana", "apple"], "vegetables": ["beetroot", "lettuce"]}
Rest LINK : http://localhost:8080/paranuara/people/food/{id}
Description : In above Rest URL, {id1} is "index" field from people.json

Example 1 : http://localhost:8080/paranuara/people/food/1
Output : {"fruits":[],"vegetables":["cucumber","beetroot","carrot","celery"],"age":60,"username":"Decker Mckenzie"}

Example 1 : http://localhost:8080/paranuara/people/food/5
Output : {"fruits":["strawberry"],"vegetables":["cucumber","beetroot","carrot"],"age":24,"username":"Grace Kelly"}


====================================================================================================
