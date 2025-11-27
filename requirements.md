# Requirements
## 1. General System Requirements
- All game displays should follow a 4:3 aspect ratio with 1024 × 768 px.
- All game displays have a consistent font style and colour palette.
- The game plays background music and sound effects where appropriate.

## 2. Menu Requirements
- The Menu screen displays the game’s name "Sonder."
- The Menu display displays a welcome message, randomly selected from a list of predetermined messages.
- The Menu display displays an image of a flower, randomly selected from a list of 14 plantable flowers, excluding the flower assigned for the 15th entry.
- The Menu screen must display 3 buttons: "Start", "Garden", and "Entries".
- Clicking "Start" must direct to the Task 1 screen, where the user may begin their daily tasks, or to the Tasks All Complete screen if they have already completed their daily tasks and/or if their garden is full (ie. contains 15 planted flowers).
- Clicking "Garden" must direct to the Garden screen, where the user can view their current garden.
- Clicking "Entries" must direct to the Entries screen, where the user can view their past entries.
- A keyboard shortcut (F1) on the Menu screen advances the internal clock to the next day, allowing the user to complete the next set of tasks (for testing purposes).
- A keyboard shortcut (F2) on the Menu screen plants 14 flowers within the garden, allowing the user the receive a special flower upon completing their daily tasks (for testing purposes).
- A keyboard shortcut (F3) on the Menu screen plants 15 flowers within the garden such that the garden is full, marking the completion of the one life cycle for the game (for testing purposes).
- A keyboard shortcut (F12) on the Menu screen clears all previous entries as a means of restarting the game's life cycle (for testing purposes).

## 3. Start Requirements
- Pressing start checks whether the daily tasks have been completed.
- If the tasks have not been completed, the start screen directs the user to the Task 1 Screen to complete their tasks in the order as follows:
   - Task 1: “how are you feeling today?” -> The user chooses between five distinct faces of varying emotions displayed on-screen. The user selects an image using their mouse. If the user clicks on the "Next" button without first selecting a face, a warning message will pop up; otherwise, the button should direct the user to the Task 2 screen.
   - Task 2: “what is one thing you’re grateful for?” -> The user inputs a written response into the given textbox. If the user clicks on the "Next" button without first inputting an answer, a warning message will pop up; otherwise, the button should direct the user to the Task 3 screen.
   - Task 3: “What is one thing you learned today? What is one goal you have for tomorrow?” -> The user inputs a written response into the given textbox. If the user clicks on the "Next" button without first inputting an answer, a warning message will pop up; otherwise, the button should direct the user to the Task 4 screen.
   - Task 4: “choose a flower for your garden.” -> The user chooses between three distinct flowers displayed on-screen which are randomly generated from a list of 14 plantable flowers, excluding the flower assigned for the 15th entry. If the user clicks on the "Next" button without first selecting a flower, a warning message will pop up; otherwise, the button should direct the user to the Task 5 screen.
      -  For the 15th entry, a unique flower is the only flower displayed on-screen for the user to select.
   - Task 5: "plant your flower into the garden." -> The user chooses a set location within the 3x5 garden grid to plant their chosen flower. If the user clicks on the "Next" button without first selecting a grid location, or selecting a grid location that already has a flower planted, a warning message will pop up; otherwise, the button should direct the user to the Tasks All Complete screen.
- If the daily tasks have been completed, the Tasks All Complete screen displays the corresponding message to notify the user.
- If the garden is full, the Tasks All Complete screen displays the corresponding message to notify the user.
- The tasks reset daily based on the internal clock.
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
