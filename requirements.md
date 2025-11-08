# Requirements
## 1. General System Requirements
- All displays throughout the game should follow a 4:3 aspect ratio with 1024 × 768 px.
- All displays have a consistent font style, colour and size
- The game plays background music and sound effects where appropriate

## 2. Menu Requirements
- The Menu screen must display the game’s name "Sonder". 
- The Menu display shows a graphic of a garden
- The Menu display shows a welcoming written message, randomly selected from a list of predetermined messages
- The Menu screen must display 3 buttons of "Start", "Garden", and "Entries".
- Clicking "Start" must direct to the “Task 1” screen, where the user may begin their daily tasks or direct to the “Tasks complete” screen if they have already completed their tasks
- Clicking "Garden" must direct to the garden screen, where the user views their current garden.
- Clicking "Entries" must direct to the entries screen, where the user views their past entries.
- For testing purposes, a keyboard shortcut on the menu screen advances the internal clock to the next day, allowing the user to complete the next set of tasks.

## 3. Start Requirements
- Pressing start checks whether the daily tasks have been completed. 
- If the tasks have not been completed, the start screen directs the user to the next screen to complete the following tasks
   - Task 1: “How are you feeling today?” The user chooses between 5 hand-drawn faces on a scale of different emotions, ranging from positive to negative. The user selects the image using the mouse, then proceeds to the next task.
   - Task 2: “What is one thing you’re grateful for?” Provides a textbox for the user to input their answer. Upon hitting NEXT, the user proceeds to the next task.
   - Task 3: “What is one thing you learned today? What is one goal you have for tomorrow?” →  Provides a textbox for the user to input their answer. Upon hitting NEXT, the user proceeds to the next task.
   - Task 4: “Choose a flower:” → user chooses one flower out of three unique options displayed on screen (randomly generated from a set of 14 total flowers).
      -  On the 15th day, a special flower with unique visuals is the only flower offered
   - Task 5: User must place their chosen flower somewhere within the 3x5 flower grid; click and press enter
- If the tasks have been completed, the start screen displays a message to the user to indicate that the tasks have already been completed for the day
- The tasks reset daily based on the internal clock
- The user’s task data is saved to a JSON file upon completing the last task
- A special message is displayed upon completing the 15th day, indicating the user has completed the two-week challenge

## 4. Garden Requirements
- The garden displays the background of a garden image
- The garden loads the previously saved garden data, even after exiting the program
- The flowers displayed in the garden match the type and location selected by the user.
- There are a total of 15 unique flowers that can be planted in the garden.
- The garden displays a 3*5 grid for planting flowers
- Each cell of the grid holds one and only one flower
- A new flower can be planted in any empty cell
- New flowers can only be added to an empty cell
- After all cells are filled, the user can select a flower to replace
- Flower type and position must be saved after the user plants the flower in a JSON file.

## 5. Entries Requirements
- Entries must be organized in a vertical list
- Entries must be organized chronologically with the most recent at the top
- Must contain a scroll bar to scroll up and down the list
- Entries must contain the date, response to all three tasks, and the flower of their choosing for the day
- Progress must be saved after the chosen flower is planted for the day
