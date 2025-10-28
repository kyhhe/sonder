# Project Description
## Team Sonder
<img width="100" height="100" alt="image" src="https://github.com/user-attachments/assets/0efa74cf-35c7-4acc-a0f1-1f3276fd1736" />

## Problem

Student mental health is often overlooked. According to the ACHC 2016 student health survey, 41.5% of students reported "[feeling] that things were hopeless", 55.3% feeling "overwhelming anxiety", 33.5% feeling "so depressed that it was difficult to function", and 5.9% who seriously considered suicide in the last 12 months (American College Health Association, 2017, p.13). These feelings can be linked to high academic pressure, financial stressors and future uncertainties during an age range with the highest risk of mental disorders. 

While everyday stressors are normal, a student struggling with managing stress has an increased risk of developing mental health disorders. Poor mental health has been associated with poorer academic performance and worse learning outcomes. These students are less motivated to engage in class, have higher drop-out rates, and are more likely to isolate themselves from their peers.

On the contrary, students who learn to manage their stress and develop strategies to support their mental health have greater resiliency when faced with hardships. They are more motivated and demonstrate higher academic performance. As such, many universities have pushed out mental health help systems for students through peer or professional counselling. However,  despite these resources, student mental health remains a challenge. Consistency is one of the key components of building good mental health habits, so some students may find it difficult to start and continue counselling. Other recommendations include daily check-ins and exercises; however, most focus on stress relief with little encouragement on keeping track of a person’s mental status.

*Citation:*
American College Health Association. National College Health Assessment II: Graduate/Professional Student Reference Group Executive Summary, Fall 2016. American College Health Association, 2017. https://www.acha.org/wp-content/uploads/2024/07/NCHA-II_FALL_2016_GRADUATE_REFERENCE_GROUP_EXECUTIVE_SUMMARY.pdf

## Solution
Our objective is to create an app/program that allows users to complete three daily wellness tasks to earn opportunities to plant flowers and plant their own, customizable garden. The user interacts with the program using their mouse and keyboard. This would encourage the user to practice mental wellness and reflect on themselves every day.

Upon launching the application, the user will see a “Menu” interface with three buttons: “Start,” “Garden,” and “Entries.” Pressing the ESC button at any point will bring you back to the menu page. The three buttons operate as follows:

1. Start:
   - Leads the user into completing the daily wellness tasks
   - Upon finishing a task, user must press ENTER to move to the next task
   - If no answer is inputted and user pressed ENTER, then an error message will pop up underneath the task title notifying that no input was given and question must be answered before next task is given
   - If all given tasks are not completed and the user presses ESCAPE, all progress is lost; pressing “Start” from the menu will navigate the user back to the first task (ie. user’s daily progress is logged into entries if and only if all five tasks are completed)
   - User’s responses to daily tasks is logged and saved into “Entries” 
   - If tasks are completed for the day and the user clicks “Start,” a different screen will pop up, stating “Thanks for checking in today, see you tomorrow!”
No other buttons are present on this page; user may navigate back to menu with ESC

2. Tasks:
   - Task 1: “How are you feeling today?” → choose between 5 hand-drawn faces of different emotions
   - Task 2: “What is one thing you’re grateful for?” → written response
   - Task 3: “What is one thing you learned today? What is one goal you have for tomorrow?” → written response
   - Task 4: “Choose a flower:” → user chooses one flower out of three options (randomly generated from a set of 9 total flowers)
   - Task 5: User must place their chosen flower somewhere within the 3x4 flower grid; click and press enter

3. Garden:
   - Loads the user’s garden (view-only page when navigated from the menu) from the JSON file
   - Able to view all the flowers you’ve planted in previous entries
   - The user will not be given a feature to reposition the flowers after setting them in the garden
   - Once the garden is filled (ie. all 12 grids have a flower), the user’s new flower will replace an existing flower within their garden
   - This is a continuous process for all succeeding entries
4. Entries:
   - Directs the user to a page to check all of their past task entries
   - Progress is logged and saved into “Entries” if all questions are answered and their chosen flower is planted
   - For every entry that is logged, 5 things are stored into a JSON file:
       1. Date
       2. User’s Response to Task 1
       3. User’s Response to Task 2
       4. User’s Response to Task 3
       5. Flower of their choosing for the day

The “Garden” and “Entries” data are saved and will carry over into the following days. The date is automatically inputted and displayed on the first task with the help of an internal clock. The daily tasks are meant to reset every 24 hours, but for simulation purposes, pressing F12 advances the internal clock to the next day and subsequently resets the daily tasks.

In terms of the visual interfaces of the app, we will be using different shades of green for all user interface pages. Flower colours will be varied. The app will have a 4:3 aspect ratio with 1024 × 768 px. All prompts will be center-aligned. User inputted responses will be left-aligned. The writing font should be consistent across all interfaces.

