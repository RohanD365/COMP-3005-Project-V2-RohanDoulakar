Name: Rohan Doulakar
Project Version 2: Health and Fitness Club Management System

Link to Video: https://youtu.be/BVwPb77fRFU

In the folder SQL it contains the files ddl.sql to create the table and
dml.sql for the insertion of the initial data set.

In the folder diagrams it contains both the ER diagram and the Relational Database Schema. The assumptions can be
found in the project report. 

In the folder project report it contains the report in a pdf file where the assumptions are stated.  

In the Main.java the main function establishes a connection with the database and an object database is created where it calls the appropriate function to execute the SQL query.
Each sql query is in a separate function which can be called when required.
The user is first asked whether the user is a member, admin, trainer, or if the user would like to exit the application.
Based on the input the next set of options will be available to the user for example if the user selects trainer then the trainer functionality will be available.

To compile the program: javac Main.java

To run the application: First make sure a database is created and initialized on pgAdmin.
Since the project uses Maven to load the org.postgresql dependency we need an IDE such as IntelliJ
where we need to right-click on Main.java and click Run 'Main.main()' and the effects will be visible on the database.