# klasa
Klasa is a web application where students and teachers can share resources, engage in discussions and manage events.
It's intuitive for teachers and feature rich for students, like no other existing platform.

# link to the site
[klasa](https://klasa-website.herokuapp.com/)

# features
1. A dashboard equipped with a calendar to keep track of all events, be it assignments, discussions, announcements or resources shared by professor/teacher
    * click on a date to find out the events of that date
2. A search feature for all resources to find what you need without the hastle of scrolling and reading through posts
2. An announcements page where you can find the announcements posted by the teacher
3. A discussions page where you can discuss your doubts with your colleagues and teachers and teaching staff
4. A resources page where you can find all the resources at one place
5. An assignments page which keeps track of all your due and submitted asignments

# technologies used
1. Bootstrap 4 for front end design
2. Spring Boot for backend (creating a RESTFUL API)
3. Spring Data JPA for database management
4. Maven for handling dependencies
5. AJAX and JQuery for making HTTP requests
6. Heroku for deployment services

# setup for running the web app locally
1. Install an IDE which supports spring, such as [IntelliJ Ultimate](https://www.jetbrains.com/idea/download/#section=linux) or [Spring Tool Suite](https://spring.io/tools)
2. Install [mySQL](https://www.mysql.com/downloads/)
3. Set up your database credentials in src/main/resources/application.properties
4. Run the demoApplication.java to run your app on [http://localhost:8080/](http://localhost:8080/)

# first draft
![klasa_first](https://user-images.githubusercontent.com/61309393/123523179-ae954000-d6df-11eb-8aef-6bb86cbf1542.png)

# backend system design first draft
![system](https://user-images.githubusercontent.com/61309393/123523250-1e0b2f80-d6e0-11eb-9396-fbc5fd0ed03c.png)
