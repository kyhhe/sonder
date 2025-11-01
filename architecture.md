# Architecture

## Entries Screen: to both client and server
   - Model which loads all past entries from the saved data in the JSON file to the clients
   - Displays all entries on the screen
   - Clears all stored entries if needed
   - Checks if any entries are currently saved
   - Does not communicate with other models directly, but does read the JSON file written by other models

## StartLogic: to server
   - Controller for the logic for displaying the user’s daily tasks.
   - Responsible for saving the user’s inputs into a JSON file when all tasks are completed
   - Communicates with *TaskScreen* (1-5) to retrieve the appropriate screen to display to the user
   - Communications 

## TaskScreen (1-5): to clients
   - View which displays the user interface where the user views the tasks and responds with their answer
   - The model communicates with the client
   - The model is managed by *StartLogic*, which handles the task to display and also the status of each task

## GardenScreen: to clients
   - View which displays all flower types and positions for any time after the flower is planted
   - Display the garden background at any time 
   - When the garden is full, display a congratulatory sentence
   - Communicates with *GardenLogic* to determine the flower placement to display on the screen. 

##GardenLogic: to server
   - Model which stores the user’s garden, including the number, type and placement of flowers
   - Writes and retrieves garden data from a JSON file, so garden data persists
   - Obtains garden data through entries written into the JSON file by other components
   - Communicates with *GardenScreen* to provide garden data to display 

## MainMenuScreen: to client
   - View which provides the interface for the user to proceed with the game. Shows the “task”, “garden”, and “entries” to navigate to other screens. Randomly selects a welcome message to display on the main menu screen along with the menu background image and begins playing the game’s background music. 
   - Navigates to *TaskScreens*, *GardenScreen* and *EntriesScreen* when the corresponding button is selected.
