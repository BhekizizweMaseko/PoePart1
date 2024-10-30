/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sgela.poepart1;

import javax.swing.JOptionPane;

/**
 *
 * @author Comfee
 */
public class PoePart1 {

    public static void main(String[] args) {

        // TODO code application logic here
        LogIn obj1 = new LogIn();

        String userName = null;
        String password = null;

        Task obj2 = new Task();

        String firstName;
        String lastName;
        String taskName;
        String taskDurationString;
        String taskAmountString;
        String taskDescription = null;
        int numTasks;
        int taskDuration;
        int[] taskHours = null;
        int totalTaskHours = 0;
        int taskAmount;

        firstName = JOptionPane.showInputDialog("Enter firstname >> ");
        System.out.print(lastName = JOptionPane.showInputDialog("Enter lastname >> "));

        obj1.setFirstName(firstName);
        obj1.setLastName(lastName);

        boolean usableUserName = false;
        while (!usableUserName) {

            userName = JOptionPane.showInputDialog("Create your username >> ");
            if (obj1.checkUserName(userName)) {
                usableUserName = true;
                continue;
            }
            JOptionPane.showMessageDialog(null, "Invalid username format. Please ensure your username contains an underscore (_) and is no more than 5 characters in length");
        }
        obj1.setUserName(userName);

        boolean usablePassword = false;
        while (!usablePassword) {
            //System.out.print("Create a password >> ");
            password = JOptionPane.showInputDialog("Create your passowrd >> ");
            if (obj1.checkPasswordComplexity(password)) {
                usablePassword = true;
                continue;
            }
            JOptionPane.showMessageDialog(null, "Invalid password format. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }
        obj1.setPassword(password);
        String registrationMessage = obj1.registerUser(userName, password);
        JOptionPane.showMessageDialog(null, registrationMessage);
        boolean loggedIn = false;
        while (!loggedIn) {
            //System.out.println(
            String loginUserName = JOptionPane.showInputDialog("Enter your username: ");
            // System.out.println(
            String loginUserPassword = JOptionPane.showInputDialog("Enter your password: ");

            if (obj1.loginUser(loginUserName, loginUserPassword)) {
                loggedIn = true;
                // JOptionPane.showMessageDialog(null, obj1.returnLoginStatus(true));
                continue;
            }
            JOptionPane.showMessageDialog(null, obj1.returnLoginStatus(false));
        }
        String loginMessage = obj1.returnLoginStatus(loggedIn);
        JOptionPane.showMessageDialog(null, loginMessage);

        //KANBAN FEATURE
        JOptionPane.showMessageDialog(null, "Hello, welcome to KANBAN!");
        boolean running = true;
        while (running) {
            // Display menu options
            String[] options = {"Add Task", "Show Report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Task Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            // SWITCH IS USED TO SEPARATE THE DIFFERENT OPTIONS PRESENTED
            switch (choice) {
                case 0 -> {
                    taskAmountString = JOptionPane.showInputDialog("How many tasks do you wish to enter?");
                    if (taskAmountString != null && !taskAmountString.isEmpty()
                            && taskAmountString.matches("\\d+")) {
                        taskAmount = Integer.parseInt(taskAmountString);
                        obj2.initializeArrays(taskAmount);
                        for (int i = 0; i < taskAmount; i++) {
                            int taskNumber = obj2.Counter++;
                            taskName = JOptionPane.showInputDialog("Enter Task " + (i) + " name:");
                            obj2.taskNames[i] = taskName;
                            boolean usableTaskDescription = false;
                            while (!usableTaskDescription) {
                                taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                                if (obj2.checkTaskDescription(taskDescription)) {
                                    usableTaskDescription = true;
                                    obj2.taskDescriptions[i] = taskDescription;
                                    JOptionPane.showMessageDialog(null, "Task captured successfully");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please enter a Task Description of less than 50 Characters.");
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Enter Developer Details.");
                            firstName = JOptionPane.showInputDialog("First Name:");
                            lastName = JOptionPane.showInputDialog("Last Name:");
                            obj2.developerDetails[i] = firstName + " " + lastName;
                            taskDurationString = JOptionPane.showInputDialog("Enter Task Duration:");
                            taskDuration = Integer.parseInt(taskDurationString);
                            obj2.taskDurations[i] = taskDuration;
                            String[] status = {"Done", "Doing", "To Do"};
                            String choice1 = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.PLAIN_MESSAGE, null, status, status[0]);
                            if (choice1 == null) {
                                JOptionPane.showMessageDialog(null, "No status selected.");
                                choice1 = "No status";
                            }
                            obj2.taskStatuses[i] = choice1;
                            String taskId = obj2.createTaskID(taskName, taskNumber, lastName);
                            obj2.taskIDs[i] = taskId;
                            obj2.printTaskDetails(taskNumber, taskId, taskName,
                                    obj2.taskDescriptions[i], taskDuration, firstName, lastName, choice1);
                        }
                        totalTaskHours = obj2.returnTotalHours();
                        JOptionPane.showMessageDialog(null, "Total Task Hours: " + totalTaskHours
                                + " hours.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number of tasks.");
                    }
                }
                case 1 -> JOptionPane.showMessageDialog(null, "Coming Soon.");

                case 2 -> JOptionPane.showMessageDialog(null, "Goodbye!");
                
                        
                

                default -> JOptionPane.showMessageDialog(null, "Invalid option, please try again later");
                
                

            }
                   // Quit the program
 JOptionPane.showMessageDialog(null, "Thank you for using Kanban!");
 running = false;
 break;
    }
 
        }

    }


