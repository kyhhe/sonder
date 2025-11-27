# Testing
## 1. Automated Tests 
Unit tests are constructed to support program logic, including garden and entries' JSON read/write, garden states and flower placement. 

### Unit Tests:<br>
entryTest<br>
flowerTest<br>
gardenLogicTest

### Unit Test Coverage: 
GardenLogic: Line-96%, Branch-85%<br>
EntryManagement: Line-77%, Branch-100%<br>
UserEntry: Line-100%, Branch-100%<br>
Flower: Line-100%, Branch-100%<br>

## 2. Manual Testing
Manual tests are manual play-testing to verify that the program meets requirements involving the graphical user interface and user actions.

### 2.1 General System Requirements
Consistent Displays: <br>
Test: Navigate through all screens<br>
Pass: Every screen has 4:3 aspect ratio, and a consistent font style

Background Music:<br>
Test: Navigate through all screens<br>
Pass: Music plays throughout the game. The song repeats after finishing (no breaks)

### 2.2 Menu Requirements
Menu loading: <br>
Test: Open the game. Navigate back to the menu page from a different screen<br>
Pass: Game name, flower image, and 3 buttons of "start", "garden", and "entries" displayed<br>

Random Welcome Message: <br>
Test: Navigate to the menu from a different screen<br>
Pass: Message changes for each time arriving on the menu page

Button Navigation:<br>
Pass: Clicking "start" -> task screen; clicking "garden" -> garden screen; clicking "entries" -> entries list

Internal Clock:<br>
Pass: screen date corresponds to real date on initial loading; Updates one day ahead when the F1 shortcut is pressed.

### 2.3 Task Requirements:
Task 1:<br>
Pass: allow switching between different mood emoji before clicking "next" onto task 2, no selecting triggers warning message

Task 2 and Task 3: <br>
Pass: allow typing text in text box, move to task 3 with "next", no text(including only space or enter) triggers warning message

Task 4: <br>
Test: Playing multiple days<br>
Pass: 1 special flower generated at 15th day, 3 random unique flowers generated for 1-14th day

Task 5:<br>
Pass: allow selecting only one empty cell to plant flower with "next"; choosing filled cell triggers warning message, flower type and position is saved when navigating to garden screen

Complete Task of the Day:<br>
Pass: "check back tomorrow" message shown when second attempt of "start"; finish message shown when all 15 flowers are planted

### 2.4 Garden Requirements
Garden background:<br>
Test: open garden from menu and after finishing task<br>
Pass: garden background is present

Flower position and Garden load/save:<br>
Test: 1. Complete task and plant a flower 2. Navigate to garden from task complete page 3. Restart the game and open the garden from the menu screen<br>
Pass: Correct flower type and position are shown in the garden, as was selected.

Test: The garden is organized in a 3x5 grid 
Pass: Allow a total of 15 flowers can be placed int the garden

### 2.5 Entries Requirements
Entries List Layout:<br>
Pass: entries appear vertical top-to-bottom list, and in chronological order with the most recent at the top

Scroll Bar: <br>
Test: Load many entries such that the content is larger than the page. Check that a scroll bar appears <br>
Pass: List scroll bar is available for scrolling from top to bottom, using mouse or scroll wheel

Entry content: <br>
Test: Complete the daily task for 3 days<br>
Pass: Each entry shows the correct date, answers to the daily questions and a flower image



