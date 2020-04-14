## be-recipe_browser
The project will create an app that allows the user to search for recipes using the **spoonacular API**. 
After returning a collection of recipes, the user can mark selected ones as "favorites", which will be saved in the local database.

### Main features
* Screening for recipes by given criteria
* User registration
* Option to add and remove selected search results to favorites
* Displaying the list of "favorites"

### Technologies
Spring Boot + Hibernate

### How to run
1) Run with IntelliJ - the project was developed using Jetbrains IntelliJ and can be imported with pom.xml file
2) (prerequisites) - you need Maven and Java 11
* 'mvn install' - to download dependencies
* 'mvn spring-boot:run' - for opening via command line
* opening web browser on http://localhost:8080 - you can expect a start page

### spoonacular API
Description and documentation can be found here: https://spoonacular.com/food-api/docs
