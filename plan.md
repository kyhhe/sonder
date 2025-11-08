# Plan
## 1. How will you coordinate your work? ##

***Who will coordinate the work?*** \
Everyone is responsible for coordinating their work with the rest of the group; however, the project manager (Kelly) oversees the group and ensures each member understands their role and responsibilities. These are decided during team meetings. Each member is responsible for holding each other accountable if the work is not completed.

***What will their project management practices be?*** \
Our project management practices prioritize clear and effective communication. This includes documenting the roles and responsibilities of each member, and our project timelines and objectives. This is to ensure our project develops at the right pace and each member has a complete understanding of the whole project. Additionally, our team values collaboration, so each member is encouraged to share their current progress and offer their opinions on the project during team meetings. 

***Will you have meetings? How frequently? Who plans their agendas?*** \
Our team conducts meetings regularly, namely, 1-2 meetings per milestone, with a general minimum of once a week. The key topics and goals for the meeting are decided, and times are coordinated in our group chat at least a day in advance. Meetings may include collaborative work time, progress updates, conducting code reviews, or planning and distributing tasks. During the team meetings, the project manager is responsible for guiding the discussion and ensuring all required points are covered. However, meetings are structured informally to allow flexibility for all team members to openly contribute and bring up any questions or concerns.

## 2. What tools will you use to communicate? ##
***For each, articulate the alternatives and why that is the best choice.*** \
Our group uses a combination of communication tools:
- **Instagram**: Used as a general-purpose group chat for scheduling team meetings, quick messages and questions. It is also used for audio calls during group meetings. This is the best choice because each member already uses Instagram for communication. It is also easily accessible on mobile, allowing for quick communication, and it supports audio calls for discussions. This is better than the alternative of email or texting because Instagram has stronger group chat features and supports photo and video messages, as well as the ability to search past messages.
- **Discord**: Used as our secondary team group chat. This is used during meetings when screen sharing is required for collaboration and visualization of ideas. This is the best choice because each member already uses Discord. The alternative would be other messaging apps, such as Instagram; however, Discord has better screen sharing features, making collaboration easier.
- **Google Docs**: Used for collaborative documents, including development of milestones. It is also used to brainstorm and track progress. This is the best choice because Google Docs supports cloud-based collaborative documents, and each group member is already familiar with the tools on Google Docs. The alternative would be Microsoft Word, however, our team is more comfortable using Google Docs because we use it more often for our other courses and projects.
- **GitHub**: Used for sharing project files and milestone submissions. This allows us to code collaboratively on our components while using others' components. It allows us to track who made what changes to the project, and allows us to view and monitor each other’s work during code reviews. There is no viable alternative to GitHub, as it is also required for project submission.

## 3 .Who will own each component in your architecture? ##
***Owning them means being responsible for writing them and making sure they are functional and correct.***
   - Kelly (Project Manager) will own the components MainMenuScreen, MainApplication, and StartLogic.
   - Anna (Designer) will own GeneralTasks, TaskManager, and UserEntry.
   - Bella (Developer) will own the components Flowers, GardenLogic, and GardenScreen.
   - Candice (Designer) will own AbstractScreen and EntriesScreen. In addition, Candice will also be in charge of the general graphics and visuals for the entire program.

## 4. What is your timeline? ##
***Include a list of milestones you'll reach and deadlines for each.***\
**Nov 7**: Milestone 3 Submission deadline
   - Record overarching plans of the project on GitHub project
   - Completion of requirements and specifications

**Nov 14**: Basic implementation
  - Implement basic user input functionality (input fields, interactions, etc.)
  - Implement basic test suite
  - Save data to a storage system 
  - Navigation between different program screens
  - Focus on functionality, not appearances. Replace UI with basic placeholder UI for now

**Nov 21**: Full implementation
   - Complete all required methods and features described in the project solution and specification
   - Implement further tests (edge cases, new methods)
   - Apply consistent UI styling across all pages
      - Spacing / alignment
      - Font and colour themes
      - Button and layout consistency
      - Handle edge cases (invalid input, full data capacity, empty states)

**Nov 28**: Milestone 4 Submission Deadline
   - Complete test cases, achieving the target of 90% branch coverage
   - Clean up code
   - Delete unused variables, dead logic
   - Ensure consistent naming and layout
   - Verify Javadoc for classes and methods
   - Write README and usage instructions
   - Final bug fixes and polish

## 5. How will you verify that you've met your requirements? ##
***For each requirement in your requirements document, detail how you will verify it, and if you won't verify it, justify why you won't. This is called an acceptance testing plan.***
### 1. General System Requirements
- All displays throughout the game should follow a 4:3 aspect ratio with 1024 × 768 px, all displays have a consistent font style, colour and size
   - Verify the above two requirements by inspecting code for each screen, ensuring each screen inherits the screen size and UI from the AbstractScreen class, which has already predefined the aspect ratio and UI elements for all screens.
- The game plays background music and sound effects where appropriate
   - Verify by running the application and navigating through all screens, ensuring the music is audible and present during the entire run time.

### 2. Menu Requirements
- The Menu screen must display the game’s name "Sonder", show a graphic of a garden, and display 3 buttons of "Start", "Garden", and "Entries".
   - Verify by running the application and ensuring the required elements are loaded onto the main menu screen.
- The Menu display shows a welcoming written message, randomly selected from a list of predetermined messages
   - Verify by running the application, leaving and returning to the menu screen multiple times to ensure the message changes each time, and that each of the predetermined messages is displayed at least once.
- Clicking "Start" must direct to the “Task 1” screen, where the user may begin their daily tasks or direct to the “Tasks complete” screen if they have already completed their tasks
   - Verify by running the application and pressing the “Start” button and observing that it directs to the Task 1 screen. Complete the tasks, then press the “Start” button again and observe whether it shows the “Tasks complete” screen.
- Clicking "Garden" must direct to the garden screen, where the user views their current garden.
   - Verify by running the application and pressing the “Garden” button and observing that it directs to the appropriate screen.
- Clicking "Entries" must direct to the entries screen, where the user views their past entries.
   -   Verify by running the application and pressing the “Start” button and observing that it directs to the appropriate screen.
- For testing purposes, a keyboard shortcut on the menu screen advances the internal clock to the next day, allowing the user to complete the next set of tasks.
   - Verify by running the application, pressing “Start” and completing one daily task. Then, press “start” again to ensure the daily completion screen is displayed. Then press the keyboard shortcut to modify the internal clock. Now, pressing “start” should direct to completing the daily task.

### 3. Task Requirements
- Pressing start checks whether the daily tasks have been completed. 
- If the tasks have not been completed, the start screen directs the user to the next screen to complete the following tasks
- If the tasks have been completed, the start screen displays a message to the user to indicate that the tasks have already been completed for the day
	- Verify the above three requirements by (1) pressing start when daily tasks are not completed and observing a transition to the task 1 screen, as well as (2) pressing start when daily tasks are completed and observing a transition to the completed tasks screen
- Task 1: “How are you feeling today?” The user chooses between 5 hand-drawn faces on a scale of different emotions, ranging from positive to negative. The user selects the image using the mouse, then proceeds to the next task.
	- Verify by checking for valid user input and ensuring the correct next step is carried out: (1) if an image is selected and user prompts for the next task, then the interface transitions to task 2 screen, otherwise, (2) if an image is not selected and user prompts for the next task, then a pop-up warning message comes up on the current task interface and there is no transition to the task 2 screen
- Task 2: “What is one thing you’re grateful for?” Provides a textbox for the user to input their answer. Upon hitting NEXT, the user proceeds to the next task.
	- Verify by checking for valid user input and ensuring the correct next step is carried out: (1) if there is a written response and user prompts for the next task, then the interface transitions to task 3 screen, otherwise, (2) if there is no written response and user prompts for the next task, then a pop-up warning message comes up on the current task interface and there is no transition to the task 3 screen
- Task 3: “What is one thing you learned today? What is one goal you have for tomorrow?” Provides a textbox for the user to input their answer. Upon hitting NEXT, the user proceeds to the next task.
	- Verify by checking for valid user input and ensuring the correct next step is carried out: (1) if there is a written response and user prompts for the next task, then the interface transitions to task 4 screen, otherwise, (2) if there is no written response and user prompts for the next task, then a pop-up warning message comes up on the current task interface and there is no transition to the task 4 screen
- Task 4: “Choose a flower:” → user chooses one flower out of three unique options displayed on screen (randomly generated from a set of 14 total flowers)
	- Verify by trial-running (simulating) to ensure that the three flowers generated are unique. Write a test case to ensure the randomization process generates three unique flowers each time.
- After finishing the task on the 15th day, a special flower with unique visuals is the only flower that is offered as a choice on the task 5 screen, and the user plants it into the flower field as outlined above. will be planted in the last cell
   - Verify that on the task 5 screen for the 15th day, only one flower, that is, the special flower, will be for selection, and the user should select and click the last empty box in the garden, then the special flower  is planted into the selected location
- Task 5: User must place their chosen flower somewhere within the 3x5 flower grid by selecting the corresponding spot
- The garden displays a 3*5 buttons for planting flowers 
   - Verify that the 15 buttons are correctly located and functioning for position selection, and in extension, verify that the flower does indeed get planted in the chosen button location
- Each cell of the grid holds one and only one flower
   - Verify by simulating user input (ie. planting a flower within the flower grid): (1) if user selects a grid that already has a flower planted, a pop-up warning message comes up on the current task interface and flower is not planted; waits for another user input attempt, or, (2) user selects a grid that does not have a flower planted, then the flower is planted into the selected location
- A new flower can be planted in any empty cell
   - Verify that the addFlower() method is called and assert the it returns true, that is, a flower is planted into the user’s chosen empty cell

- Flower type and position must be saved after the user plants the flower in a JSON file.
		- Verify by calling on methods saveGarden() and loadGarden() and ensure that the output content matches inputs
	- Verify by checking for valid user input and ensuring the correct next step is carried out: (1) if a designated spot within the flower grid is selected and user prompts for the next task, then the interface plants the chosen flower in that position, otherwise, (2) if a designated spot within the flower grid is not selected and user prompts for the next task, then a pop-up warning message comes up on the current task interface and there is no transition to a different screen
- The tasks reset daily based on the internal clock
	- Verify by simulating with an internal clock to replicate daily task resets and ensure that the tasks reset if and only if the “day” is over
- The user’s task data is saved to a JSON file upon completing the last task
	- Verify by checking that the data from all five tasks are stored in the correct file type (JSON) and are an accurate reflection of what was actually inputted by the user for the day; by clicking “entries” from the menu screen, we can also verify visually that the entry logs are saved properly. 
- A special message is displayed on the task 5 screen upon completing the 15th day, indicating the user has completed the two-week challenge
	- Verify through simulation that the special message is correct and does indeed pop up after the 15th day is completed (ie. all tasks for day 15 are completed)

### 4. Garden Requirements
- The garden displays the background of a garden image
   - Verify by launching the Garden screen, then the background image is displaying in the background 
- The garden loads the previously saved garden data, even after exiting the program
	- Unit and visual test: - plant a flower
		- call saveGarden()
		- close the application; navigate to a different screen
		- call loadGarden() and visually verify the flower type and position
- The flowers displayed in the garden match the type and location selected by the user.
	- Verify by navigating back to the Garden screen when completing the daily task, and checkthat  the flower type and position are shown as selected
- There are a total of 15 unique flowers that can be planted in the garden.
	- Verify with a test case, where total flower size == 15 on the 15th day

### 5. Entries Requirements
- Entries must be organized in a vertical list
   - Verify by loading multiple entries into a JSON file, then running the application and observe that the entries are displayed in a vertical layout
- Entries must be organized chronologically with the most recent at the top
   - Verify by creating test entries with different dates, ensure that the most recent entry is displayed at the top of the entries screen after reloading the program 
- Must contain a scroll bar to scroll up and down the list
   - Verify by loading enough entries into a JSON file to exceed the height limit, then reload the application and attempt to scroll up and down on the entries page
- Entries must contain the date, response to all three tasks, and the flower of their choosing for the day
   - Verify by creating an entry using the application itself, then going to the entries screen to make sure all necessary elements are present. Additionally, check the JSON file to make sure all elements are present

***If you propose to write tests, what exact tests will you conduct and what will count as each test passing?***
Ideally, our team will aim for high statement coverage and branch coverage, similar to the standards set for the mini-projects.
More specifically, we want to validate the correctness of the various methods, classes, and interfaces that make up the project. This includes, but is not limited to
   - Screen transitions,
   - Input validation process,
   - Saving user input and data storage (ie. saving and writing to files stored in “entries”), and the operation of one full app cycle.
Additionally, we will conduct manual testing on our project to verify user-interactive features. A passing test would ensure that the behaviour of the specified portion of the project aligns with what is outlined in our requirements.
	
***If you propose to conduct reviews or inspections, how will you analyze the code?*** \
We will conduct peer code reviews/inspections, that is, we will read each other’s code to check for any syntax errors, incorrect coding style, etc. We will also test with the GUI to check for any major defects with user input, screen transitions, pop-up messages, daily reset of the app’s functions, etc.

***If you write a proof, what property will you prove?*** \
N/A. Our project does not implement any algorithm(s) that require a proof.

***If you conduct a review or inspection, what aspects of the code will you inspect to verify the requirement is met?*** \
For code review, we will analyze the general logic of the code to ensure it complies with the specification. We will observe whether there are redundant or unnecessary lines of code to be optimized. We will also ensure the code communicates with the components as required. 

***For all of the requirements, how will your verifications be integrated into your process? Will you run automated tests after every build? Before every commit? When will you conduct inspections and who will be involved?*** \
Verification will be integrated into our process by adding test cases as outlined above, before or during the building of each new part. Tests will be run before every commit to make sure new commits do not break existing code. Code inspections will be held weekly during the development phase of the project, and each member is expected to attend and participate.

## 6. Reflection: Resilience against Disasters
***To make a good plan, brainstorm disasters that might happen and test your plan against them. Illness, injury, API limitations, difficult to fix bugs: how resilient is your plan to all of these crises? ***
To ensure our plan is robust and resilient, some common “disasters” are outlined below and tested against our plan.
1. In the case of illness or injury of a given team member, we will prioritize communication, such that other team members are notified of these occurrences as soon as they happen to allow for task redistribution to be both effective and efficient.
2. With software, it’s to be expected that our team will have to handle difficult software bugs (eg. unable to transition(s) between different user interface screens, compilation fails, etc). We will refer to both class-affiliated resources (ie. Piazza and TA/professor office hours)  and free online resources (ie. Java Reference Documentation, Java/GUI Tutorials, etc). We may also reach out to other group members for code reviews and constructive feedback.
3. Since our team works with a shared GitHub repository, there may be GitHub merging conflicts. To mitigate this, each member ensures that they pull/push regularly from/to the repository and notify other teammates when they’re committing changes and/or modifying any components that are otherwise not assigned to them.
4. To ensure the project’s coding style is consistent across code written by different team members, we will refer to the coding style guidelines outlined in the CPEN 221 course (ie. the style that is expected for the mini-projects) to ensure that any minor discrepancies between coding styles are eliminated. 

## Minimum Viable Product
***From an implementation perspective, you may not have the time to build out all the features that you listed and you should prioritize your design effort with a focus on building a minimum viable product. How you prioritize features and integrate this prioritization into your plan matters.*** \
Given time constraints, our development will prioritize implementing the minimum viable product that provides the core experience of Sonder for the first 15 days. By completing all items for a Minimum Viable Product, the application will be fully playable and functional.

**Minimum Viable Product:**
- Enable navigation between different pages(Menu, Start, Garden, Entries)
- Implementing the daily task system (all 5 tasks)
- Enable user input
- Support local data saving and loading across multiple days

**Extended gameplay features:**
- Implement flower replacement when the garden is full (after the first 15 days)
- Increase task question variety (larger pool of questions and flower types)
- Improving the background music and sound effects
- Add animations and visuals to enhance engagement
