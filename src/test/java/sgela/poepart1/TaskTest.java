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
public class TaskTest {
    
   
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.initializeArrays(5);  // Initialize with 5 tasks for testing
    }

    @Test
    void testCheckTaskDescription_ValidDescription() {
        assertTrue(task.checkTaskDescription("This is a valid task description."));
    }

    @Test
    void testCheckTaskDescription_TooLongDescription() {
        String longDescription = "This description is way too long to be valid as it exceeds fifty characters.";
        assertFalse(task.checkTaskDescription(longDescription));
    }

    @Test
    void testReturnTotalHours_EmptyDurations() {
        assertEquals(0, task.returnTotalHours());
    }

    @Test
    void testReturnTotalHours_WithDurations() {
        task.taskDurations[0] = 5;
        task.taskDurations[1] = 3;
        task.taskDurations[2] = 2;
        assertEquals(10, task.returnTotalHours());
    }

    @Test
    void testCreateTaskID_ValidInputs() {
        String taskID = task.createTaskID("TaskName", 1, "DeveloperLastName");
        assertEquals("TA-1-NME", taskID);
    }

    @Test
    void testCreateTaskID_ShortLastName() {
        String taskID = task.createTaskID("TaskName", 1, "Dev");
        assertEquals("TA-1-DEV", taskID);
    }

    @Test
    void testDisplayAllTasks_NoTasks() {
        // In this case, we can't directly test GUI output. 
        // Instead, we might want to refactor the method to return a string for testing purposes.
        task.displayAllTasks(); // Just checking if it runs without exceptions
        // You could verify with a mocked JOptionPane if necessary
    }

    // Add more tests as needed
}
    

