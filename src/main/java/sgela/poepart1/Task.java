/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgela.poepart1;
import javax.swing.*;

/**
 *
 * @author Comfee
 */
public class Task {
         String[] taskNames; 

        String[] taskIDs; 

        String[] developerDetails; 

        String[] taskDescriptions; 

        int[] taskDurations; 

        String[] taskStatuses; 

         boolean[] isDeleted; 

        int Counter = 0; 

  

        // Initialize arrays based on the number of tasks 

        public void initializeArrays(int size) { 

            taskNames = new String[size]; 

            taskIDs = new String[size]; 

            developerDetails = new String[size]; 

            taskDescriptions = new String[size]; 

            taskDurations = new int[size]; 

            taskStatuses = new String[size]; 

             isDeleted = new boolean[size]; 

        } 

  

        // METHOD TO CHECK TASK DESCRIPTION 

        public boolean checkTaskDescription(String taskDescription) { 

            return taskDescription.length() <= 50; 

        } 

  

        // METHOD TO CHECK TASK DETAILS 

        public void printTaskDetails(int taskNumber, String taskId, String taskName, String taskDescription, 

                                     int taskDuration, String firstName, String lastName, String choice1) { 

            String message = 

                    "Task Status: " + choice1 + "\n" + 

                    "Developer Details: " + firstName + " " + lastName + "\n" + 

                    "Task Number: " + taskNumber + "\n" + 

                    "Task Name: " + taskName + "\n" + 

                    "Task Description: " + taskDescription + "\n" + 

                    "Task ID: " + taskId + "\n" + 

                    "Task Duration: " + taskDuration + " hours"; 

  

            JOptionPane.showMessageDialog(null, message); 

        } 

  

        // METHOD TO CALCULATE AND RETURN THE TOTAL HOURS 

        public int returnTotalHours() { 

            int total = 0; 

            for (int taskDuration : taskDurations) { 

                total += taskDuration; 

            } 

            return total; 

        } 

  

        // METHOD TO CREATE TASKID 

        public String createTaskID(String taskName, int taskNumber, String lastName) { 

            String taskID = ""; 

            taskID += taskName.substring(0, Math.min(2, taskName.length())).toUpperCase(); 

            taskID += "-" + taskNumber; 

  

            if (lastName.length() >= 3) { 

                taskID += "-" + lastName.substring(lastName.length() - 3).toUpperCase(); 

            } else { 

                taskID += "-" + lastName.toUpperCase(); 

            } 

            return taskID; 

    } 

    // METHOD TO DISPLAY ALL TASKS 

     public void displayAllTasks() { 

        StringBuilder message = new StringBuilder("All Captured Tasks:\n\n"); 

        boolean found = false; 

        for (int i = 0; i < taskNames.length; i++) { 

            if (!isDeleted[i] && taskNames[i] != null) { 

                message.append("Task Number: ").append(i + 1).append("\n") 

                        .append("Task Name: ").append(taskNames[i]).append("\n") 

                        .append("Developer: ").append(developerDetails[i]).append("\n") 

                        .append("Task ID: ").append(taskIDs[i]).append("\n") 

                        .append("Task Duration: ").append(taskDurations[i]).append(" hours\n") 

                        .append("Task Status: ").append(taskStatuses[i]).append("\n\n"); 

                found = true; 
            }
        }
     }
}
            

        

 



  

