## CRUD PROJECT

#### Contents
1.	Resources
2.	Brief
3.	Scrum Kanban Board
4.	Database
5.	Backend
6.	Testing
7.	Frontend
8.	Continued Development

#### Resources
* Presentation - [google slides](https://docs.google.com/presentation/d/1iGmPdOANXnOZLVC4skH1TBxas6Vv-GnSfqINt74PAAU/edit?usp=sharing)
* Scrum Board - [Atlassian](https://team-1624352124374.atlassian.net/jira/software/projects/FP/boards/3/roadmap?shared=&atlOrigin=eyJpIjoiY2JhNDU2YjQwYjdhNDUzYThlYzBhZmIzODNiZWJlNGQiLCJwIjoiaiJ9)

#### Brief
The brief for this project was to create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.
This project involves concepts from all of the core training modules:
* Project Management
* Databases
* Java SE
* Spring Boot
* Frontend Development

#### Project Management
First, I created a list of features for my app and prioritised them using the MoSCow method, and the features required for the application to meet the minimum viable product under the must have column.

![image1](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image1.png)

![image2](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image2.png)

In order to manage my project, I used Jira Software to create an Agile Scrum Board which is online on Atlassian (link provided under resources). I used this to create User stories based on the features, Epics, and tasks. I provided each of these epics, user stories and tasks with story point estimates to help me judge how much work I had remaining. 
Example of user stories below

![image3](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image3.png)

Example of story point estimates and prioritisation on Scrum board, and example of a Sprint.

![image4](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image4.png)

#### Version Control
I used GitHub as a Version Control System for this application. I created two public repositories one for the backend code and one for the frontend code. I created branches off the develop branch in order to track and manage changes to my code, whilst ensuring that I always maintained a working version which I could go back to if needed.

Example of the network graph for my backend repository.

![image5](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image5.png)

Example of the network graph for my frontend repository

![image6](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image6.png)

#### Databases
I used a local H2 database for the testing of my application, as it doesn’t persist data. 

![image7](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image7.png)

I used a game-schema.sql to create and drop this table between each test, I also used a game-data.sql to insert a specific record into the database for each test so that I knew exactly what the database would contain at the beginning of each test. By using a local database it was a convenient approach to creating a database which didn’t persist data as it was dropped after every test.

I used a MySQL database for production purposes (attached to the frontend) as it persists data.

![image8](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image8.png)

Here is an ERD (Entity Relationship Diagram) for the structure of both of my databases.

![image9](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image9.png)

#### Backend
I used the Spring Boot Framework to create a Java application. By using this framework I was able to connect the database, the backend and the frontend effectively within one application. I was able to set up both databases within Spring Boot, as well as create the HTTP requests for the frontend.

#### Testing
I created a number of both integration and unit tests for my backend application. As shown below there were a total of 23 tests for my application

![image10](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image10.png)

I created 12 Unit tests using Mockito to try and test a single method by mocking the repo, which doesn’t need to be tested within Unit tests. These tests were ran using Junit 5.

![image11](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image11.png)

I created 10 integration tests based on my functions within my GameController Class. I created these using MockMVC to mock the controller and mock the HTTP requests that a user might make.

![image12](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image12.png)

Before creating the databases to test my HTTP requests I used Postman to test these requests to make sure that they worked. That way I knew that they should work based on the current code once I created the H2 and SQL databases. This helped me narrow down whether the errors were occurring dur to an issue with the databases or with the HTTP requests.

![image13](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image13.png)

![image14](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image14.png)

#### Frontend
I created the layout of the web page using HTML, and implement JavaScript into the web page to make it more interactive for the user. I then used CSS and utilised Bootstrap to change the layout using containers, classes and styling. I used JavaScript to integrate my HTTP requests and database information on to the frontend for the user to implement the CRUD functionality. 

Below is the screenshot of my final website.

![image15](https://raw.githubusercontent.com/StephN9/Fundamental-Project-Backend/readme/readme_pictures/image15.png)

----------------------------------

#### Continued Development
If I were to develop my project further, I would focus on:
* Creating a modal form using Bootstrap to update the game entries rather than having the user fill in the create game form.
* I would create a separate section (a list) or tag that the user could apply to games they are currently playing, so that they were separate from the other games in the library. 
* I would create a modal which would contain a warning that the user had to confirm in order to delete a game entry from the game Library.
