## be-recipe_browser
The project will create an app that allows the user to search for recipes using the **spoonacular API**. 
The app allows to search for:
1. specific recipe using keywords (e.g. pasta),
2. recipies matching ingredients users have in their possesion (e.g. eggs, flour, butter),
3. random recipe from database.

After returning a collection of recipes, the user can mark selected ones as "favorites", which will be saved in the local database.

### Main features
* Screening for recipes by given criteria
* User registration
* Option to add and remove selected search results to favorites
* Displaying the list of "favorites"

### Technologies
Spring Boot + Hibernate

### How to run
(prerequisites) - you need Maven, Lombok and Java 11
* 'mvn install' - to download dependencies
* 'mvn spring-boot:run' - for opening via command line
* opening web browser on http://localhost:8080 - you can expect a start page

Project uses MySQL and the database will be automatically created. In application.poperties file below parameters were used:
spring.datasource.username=root
spring.datasource.password=root


### spoonacular API
Description and documentation can be found here: https://spoonacular.com/food-api/docs
