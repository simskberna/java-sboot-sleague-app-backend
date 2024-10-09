NWSL App Backend - Spring Boot API
Overview
Welcome to the NWSL App Backend! This is a RESTful API developed with Spring Boot and powered by PostgreSQL as the backend database. Our API supports essential CRUD operations—Create, Read, Update, and Delete—facilitating seamless interaction with player data.

Features
GET Requests: Efficiently retrieve data from the database.
POST Requests: Create new player records.
PUT Requests: Update existing player information.
Requirements
Java: 23 or later
PostgreSQL
Maven
Setup Instructions
Clone the Repository
Clone this repository to your local machine using:

git clone https://github.com/your-repo/nwsl-app-backend.git
Configure PostgreSQL
Set up your PostgreSQL database and update the application.properties file with your database credentials.

Run the Application
Launch the application with the following command:

mvn spring-boot:run
API Endpoints
Player Management
GET /api/v1/player
Fetch all players.

GET /api/v1/player?name={name}
Fetch players based on names.
Example: /api/v1/player?name=Alex

GET /api/v1/player?position={position}
Fetch players based on positions.
Example: /api/v1/player?position=FW

POST /api/v1/player
Create a new player.
Request Body:

{
  "name": "Tobin Heath",
  "team": "Portland Thorns",
  "position": "FW",
  "nation": "USA",
  "age": 33,
  "goals": 245
}
PUT /api/v1/player/{id}
Update a player by ID.
Request Body:

{
  "id": 1,
  "name": "Alex Morgan",
  "team": "San Diego Wave FC",
  "position": "FW",
  "nation": "USA",
  "age": 34,
  "goals": 21
}
Alternatively, you can update by name.

Contributing
Thank you for checking out the NWSL App Backend! We hope you find it useful for managing player data effectively. Enjoy coding!
