# Project Description

## Team Sonder
<img width="100" height="100" alt="image" src="https://github.com/user-attachments/assets/0efa74cf-35c7-4acc-a0f1-1f3276fd1736" />

*Mission Statement: Cultivating daily mindfulness.*

### Quick Links

[INSTALLATION GUIDE](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/installation.md) |
[Known Bugs](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/knownBugs.md) |
[Project Requirements](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/requirements.md) |
[Project Architecture](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/architecture.md) |
[Project Plan](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/plan.md) |
[Project Testing](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/testing.md) |
[Contributions Statement](https://github.com/CPEN-221-2025/project-poplar/blob/main/documentation/contributions.md)

## Problem

Student mental health is often overlooked. According to the ACHC 2016 student health survey, 41.5% of students reported "[feeling] that things were hopeless", 55.3% feeling "overwhelming anxiety", 33.5% feeling "so depressed that it was difficult to function", and 5.9% who seriously considered suicide in the last 12 months (American College Health Association, 2017, p.13). These feelings can be linked to high academic pressure, financial stressors and future uncertainties during an age range with the highest risk of mental disorders. 

While everyday stressors are normal, a student struggling with managing stress has an increased risk of developing mental health disorders. Poor mental health has been associated with poorer academic performance and worse learning outcomes. These students are less motivated to engage in class, have higher drop-out rates, and are more likely to isolate themselves from their peers.

On the contrary, students who learn to manage their stress and develop strategies to support their mental health have greater resiliency when faced with hardships. They are more motivated and demonstrate higher academic performance. As such, many universities have pushed out mental health help systems for students through peer or professional counselling. However,  despite these resources, student mental health remains a challenge. Consistency is one of the key components of building good mental health habits, so some students may find it difficult to start and continue counselling. Other recommendations include daily check-ins and exercises; however, most focus on stress relief with little encouragement on keeping track of a person’s mental status.

*Citation:*
American College Health Association. National College Health Assessment II: Graduate/Professional Student Reference Group Executive Summary, Fall 2016. American College Health Association, 2017. https://www.acha.org/wp-content/uploads/2024/07/NCHA-II_FALL_2016_GRADUATE_REFERENCE_GROUP_EXECUTIVE_SUMMARY.pdf

## Solution
Our objective is to create an interactive application/program that allows users to complete five daily wellness tasks, earning opportunities to plant flowers and grow their own, customizable garden. Through our chosen methodology, we hope to encourage and inspire users to practice daily mindfulness and introspection.

The user is able to interact with our program using their mouse and keyboard. Upon launching the application, the user will see a “menu” interface with three buttons: “start,” “garden,” and “entries,” respectively. The three buttons operate as follows:
<img width="1024" height="700" alt="image" src="https://github.com/user-attachments/assets/94c19134-09ec-4c27-8c1a-cc49b290b3e0" />
<img width="470" height="700" alt="image" src="https://github.com/user-attachments/assets/bb20b25c-ae63-4439-bac3-9a0ede1f4721" />

1. Start:
   - Leads the user into completing the five daily wellness tasks:
      - Task 1: “how are you feeling today?” -> choose between five distinct faces of varying emotions.
        <img width="1000" height="700" alt="image" src="https://github.com/user-attachments/assets/0d972606-d2b5-44b7-9c3b-3f786848833a" />
     
      - Task 2: “what is one thing you’re grateful for?” -> written response
    
      - Task 3: “wat is one thing you learned today? what is one goal you have for tomorrow?” -> written response
        <img width="1000" height="700" alt="image" src="https://github.com/user-attachments/assets/aa156e3c-4469-4c9d-83e9-c81c046f0f56" />
     
      - Task 4: “choose a flower for your garden.” -> choose between three distinct flowers displayed, randomly generated from a list of 14 flowers.
        <img width="470" height="700" alt="image" src="https://github.com/user-attachments/assets/012934c7-72d7-41cd-ac90-a00b61449934" />
        
      - Task 5: "plant your flower into the garden." -> plant the chosen flower somewhere within the 3x5 garden grid.
        <img width="1000" height="700" alt="image" src="https://github.com/user-attachments/assets/e0f1d3ed-2ecc-4588-8c84-2a4e1241ba17" />

   - Upon completing a given task, the user must click the "next" button to proceed to the next task.
   - If no answer is inputted and the user clicks "next", an error message will pop up underneath the task prompt, notifying the user that no input was given and the question must be answered before the next task is given.
   - The user’s responses to daily tasks are logged in a JSON file and saved into “Entries.”
   - If tasks are completed for the day and the user clicks “Start” from the "menu" screen, a different screen will pop up, notifying the user with a message stating that their daily tasks have already been completed; this screen contains a "menu" button.
   - If the garden is full (ie. contains 15 planted flowers) and the user clicks "Start" from the "Menu" screen, then a different screen will pop up, notifying the user with a message stating that their garden is full and they have completed the two week mental health challenge; this screen contains a "menu" button.

2. Garden:
   - Loads the user’s garden (view-only page when navigated from the "menu" screen), including all previously planted flowers in their respective grid locations.
   - The user will not be given a feature to reposition the flowers after setting them in the garden.
   - Each cell within the garden grid is only able to support one flower at any given time. Subsequent flowers can only be planted in empty cells.
   - Once the garden is full, the user is unable to plant any new flowers, or replace any existing ones.

3. Entries:
   - Directs the user to a page containing all past task entries, organized vertically and in  chronological order such that the most recent entry appears at the top.
   - Progress is logged and saved into the “entries” screen if and only if all five wellness tasks are completed.
   - For every entry that is logged, 5 things are stored in a JSON file:
       1. Entry date
       2. User’s response (ie. an image of the selected face) to Task 1
       3. User’s written response to Task 2
       4. User’s written response to Task 3
       5. User's response (ie. an image of the selected flower) to Task 4

The “garden” and “entries” data are saved and will carry over into the following days. This data does not clear upon closing the application. The date is displayed on the "menu" screen. The daily tasks are meant to reset every 24 hours, but for simulation purposes, pressing F1 advances the clock to the next day and subsequently resets the daily tasks.

In terms of the visual interfaces of the app, we will be using different shades of green for all user interface pages. Flower colours will be varied. All flowers, however, are set to 150 x 150 px. The app will have a 4:3 aspect ratio with 1024 × 768 px. All prompts will be center-aligned. User inputted responses will be left-aligned. The writing fonts should be consistent across all interfaces.
