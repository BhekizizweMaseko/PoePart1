/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sgela.poepart1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Comfee
 */
public class PoePart1Test {
    
    public PoePart1Test() {


class TaskManagerTest {
    private Task task;
    private LogIn logIn;

    @BeforeEach
    void setUp() {
        // Initialize objects
        task = new Task();
        logIn = new LogIn();

        // Add some initial tasks for testing
        task.initializeArrays(3);
        task.taskNames[0] = "Task 1";
        task.taskDescriptions[0] = "Description 1";
        task.developerDetails[0] = "Alice Johnson";
        task.taskDurations[0] = 5;
        task.taskStatuses[0] = "Done";
        task.taskIDs[0] = task.createTaskID("Task 1", 1, "Johnson");

        task.taskNames[1] = "Task 2";
        task.taskDescriptions[1] = "Description 2";
        task.developerDetails[1] = "Bob Smith";
        task.taskDurations[1] = 3;
        task.taskStatuses[1] = "Doing";
        task.taskIDs[1] = task.createTaskID("Task 2", 2, "Smith");

        task.taskNames[2] = "Task 3";
        task.taskDescriptions[2] = "Description 3";
        task.developerDetails[2] = "Charlie Brown";
        task.taskDurations[2] = 7;
        task.taskStatuses[2] = "To Do";
        task.taskIDs[2] = task.createTaskID("Task 3", 3, "Brown");
    }

    @Test
    void testDeveloperArrayDisplayedCorrectlyPopulated() {
        String[] expectedDevelopers = {"Alice Johnson", "Bob Smith", "Charlie Brown"};
        assertArrayEquals(expectedDevelopers, task.developerDetails);
    }

    @Test
    void testDisplayTaskWithLongestDuration() {
        String expectedOutput = "Task with the longest duration: Task 3 (7 hours) by Charlie Brown";
        
    }

    @Test
    void testSearchForTask() {
        int taskNumberToSearch = 2; // Task 2
        String expectedOutput = "Task ID: TSK:2:Smith, Name: Task 2, Duration: 3, Developer: Bob Smith";
        
    }

    @Test
    void testSearchAllTasksAssignedToDeveloper() {
        String developerName = "Alice Johnson";
        String[] expectedTasks = {"Task 1"};
       
    }

    @Test
    void testDeleteTaskFromArray() {
        int taskNumberToDelete = 1; // Task 1
        task.deleteTask(taskNumberToDelete);
        assertNull(task.taskNames[0]);
        assertNull(task.taskDescriptions[0]);
    }

    @Test
    void testDisplayReport() {
        String expectedReport = """
            Task Report:
            Task ID: TSK:1:Johnson, Name: Task 1, Status: Done, Developer: Alice Johnson
            Task ID: TSK:2:Smith, Name: Task 2, Status: Doing, Developer: Bob Smith
            Task ID: TSK:3:Brown, Name: Task 3, Status: To Do, Developer: Charlie Brown
        """;
        
    }
}

    
}
}
