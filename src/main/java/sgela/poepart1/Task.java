/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgela.poepart1;
import javax.swing.JOptionPane;

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
 public void printTaskDetails(int taskNumber, String taskId, String taskName, String 
taskDescription,
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
 
 // METHOD TO SEARCH TASK BY NUMBER
 public void searchTask(int taskNumber) {
 for (int i = 0; i < taskNames.length; i++) {
 if (taskNames[i] != null && (Counter - taskNames.length + i) == taskNumber) {
 String message =
 "Task Status: " + taskStatuses[i] + "\n" +
 "Developer Details: " + developerDetails[i] + "\n" +
 "Task Name: " + taskNames[i] + "\n"; 
 JOptionPane.showMessageDialog(null, message);
 return;
 }
 }
 JOptionPane.showMessageDialog(null, "Task not found.");
 }
 
 // METHOD TO DELETE TASK
 public void deleteTask(int taskNumber) {
 for (int i = 0; i < taskNames.length; i++) {
 if (taskNames[i] != null && (Counter - taskNames.length + i) == taskNumber) {
 taskNames[i] = null;
 taskIDs[i] = null;
 developerDetails[i] = null;
 taskDescriptions[i] = null;
 taskDurations[i] = 0;
 taskStatuses[i] = null;
 JOptionPane.showMessageDialog(null, "Task deleted successfully.");
 return;
 }
 }
 JOptionPane.showMessageDialog(null, "Task not found.");
 }
 public void deleteTassk(int taskNumber) {
 if (taskNumber > 0 && taskNumber <= taskNames.length && taskNames[taskNumber -
1] != null) {
 taskNames[taskNumber - 1] = null;
 taskIDs[taskNumber - 1] = null;
 developerDetails[taskNumber - 1] = null;
 taskDescriptions[taskNumber - 1] = null;
 taskDurations[taskNumber - 1] = 0;
 taskStatuses[taskNumber - 1] = null;
 JOptionPane.showMessageDialog(null, "Task " + taskNumber + " deleted successfully.");
 } else {
 JOptionPane.showMessageDialog(null, "Invalid task number.");
 }
 }
 
 public void displayTasksWithStatusDone() {
 StringBuilder message = new StringBuilder("Tasks with Status 'Done':\n\n");
 boolean found = false;
 for (int i = 0; i < taskNames.length; i++) {
 if (taskStatuses[i] != null && taskStatuses[i].equals("Done")) {
 message.append("Task Number: ").append(Counter - taskNames.length + 
i).append("\n")
 .append("Task Name: ").append(taskNames[i]).append("\n")
 .append("Developer: ").append(developerDetails[i]).append("\n")
 .append("Task ID: ").append(taskIDs[i]).append("\n")
 .append("Task Duration: ").append(taskDurations[i]).append(" hours\n\n");
 found = true;
 }
 }
 if (!found) {
 message.append("No tasks with status 'Done'.");
 }
 JOptionPane.showMessageDialog(null, message.toString());
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
 if (!found) {
 message.append("No tasks found.");
 }
 JOptionPane.showMessageDialog(null, message.toString());
 }
 
 // METHOD TO DISPLAY TASK WITH LONGEST DURATION
 public void displayTaskWithLongestDuration() {
 int longestDuration = 0;
 int longestIndex = -1;
 for (int i = 0; i < taskDurations.length; i++) {
 if (taskDurations[i] > longestDuration) {
 longestDuration = taskDurations[i];
 longestIndex = i;
 }
 }
 if (longestIndex != -1) {
 String message = "Task with Longest Duration:\n\n" +
 "Task Number: " + (longestIndex + 1) + "\n" +
 "Task Name: " + taskNames[longestIndex] + "\n" +
 "Developer: " + developerDetails[longestIndex] + "\n" +
 "Task ID: " + taskIDs[longestIndex] + "\n" +
 "Task Duration: " + taskDurations[longestIndex] + " hours";
 JOptionPane.showMessageDialog(null, message);
 } else {
 JOptionPane.showMessageDialog(null, "No tasks found.");
 }
 }
 
 public void searchTasksByDeveloper(String developerName) {
 StringBuilder message = new StringBuilder("Tasks Assigned to " + developerName + 
":\n\n");
 boolean found = false;
 for (int i = 0; i < developerDetails.length; i++) {
 if (developerDetails[i].equalsIgnoreCase(developerName)) {
 message.append("Task Number: ").append(i + 1).append("\n")
 .append("Task Name: ").append(taskNames[i]).append("\n")
 .append("Task ID: ").append(taskIDs[i]).append("\n")
 .append("Task Duration: ").append(taskDurations[i]).append(" hours\n")
 .append("Task Status: ").append(taskStatuses[i]).append("\n\n");
 found = true;
 }
 }
 if (!found) {
 message.append("No tasks found for this developer.");
 }
 JOptionPane.showMessageDialog(null, message.toString());
 }
 
 // Methods to capture and return outputs for unit tests
 public String getLongestDurationTaskDetails() {
 int longestDuration = 0;
 int longestIndex = -1;
 for (int i = 0; i < taskDurations.length; i++) {
 if (taskDurations[i] > longestDuration) {
 longestDuration = taskDurations[i];
 longestIndex = i;
 }
 }
 if (longestIndex != -1) {
 return developerDetails[longestIndex] + ", " + taskDurations[longestIndex];
 } else {
 return "No tasks found.";
 }
 }
 public String searchTaskByName(String taskName) {
 for (int i = 0; i < taskNames.length; i++) {
 if (taskNames[i] != null && taskNames[i].equals(taskName)) {
 return developerDetails[i] + ", " + taskNames[i];
 }
 }
 return "Task not found.";
 }
 public String searchTasksByDeveloperName(String developerName) {
 for (int i = 0; i < developerDetails.length; i++) {
 if (developerDetails[i].equals(developerName)) {
 return taskNames[i];
 }
 }
 return "No tasks found for this developer.";
 }
public String getAllTasksDetails() {
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
 if (!found) {
 message.append("No tasks found.");
 }
 return message.toString();
 }

    
}
            

        

 



  

