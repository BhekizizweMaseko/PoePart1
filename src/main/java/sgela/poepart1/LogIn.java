/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgela.poepart1;
import java.util.*;

/**
 *
 * @author Comfee
 */
public class LogIn {
    
   static  String username, password, firstName, lastName;
    
    //registration of user
        public static void registerUser() {
        //object for scanner
        Scanner take_input = new Scanner(System.in);
        
        //prompt the user for both username, password, firstName and lastName
        System.out.println("Enter username");
        String username= take_input.nextLine();
        
        System.out.println("Enter password");
        String password= take_input.nextLine();
        
        System.out.println("Enter first name");
        String firstName = take_input.nextLine();
        
        System.out.println("Enter last name");
        String lastName = take_input.nextLine();
        //method to check password and username
        checkUsername(username);
        checkPasswordComplexity(password);
    }
    
    public static boolean loginUser() {
        //object for scanner
        Scanner take_input = new Scanner(System.in);
        
        //log in details prompt
        System.out.println("Enter username");
        String username = take_input.nextLine();
        
        System.out.println("Enter password");
        String password = take_input.nextLine();
        
        //method to check password and username
        checkUsername(username);
        checkPasswordComplexity(password);
       return false;
        
}
    
    //method to check username and password
    public static void returnLoginStatus() {
if (loginUser()) {
    System.out.println("Welcome! "+firstName+" "+lastName+" Its great to see you again!");
    
}
    }
    
     //method to check the password    
    public static boolean checkPasswordComplexity(String password) {
        
    if(password.length() > 7)
    {
     //return success
        System.out.println("Password successfully captured");
    }
    else
    {
      //error message
System.out.println("Password is not correctly formatted, please ensure that your password contains at least 8 characters, a capital letter, a number and a special character");
        }
    
    boolean hasNum = false; boolean hasCap = false; boolean hasLow = false; char c; boolean hasSpecialChar = false;
    
    //declarations for special characters
    String specialCharacters = "!@#$%^&*()-+=<>?";
    
    for (int i = 0; i < password.length(); i++)
    {
      c = password.charAt(i);
      if(Character.isDigit(c));
      {
      hasNum = true;
      }
       if (specialCharacters.indexOf (c) >= 0) {
              hasSpecialChar = true;
              }
      if(Character.isUpperCase(c))
              {
              hasCap = true;
              }
      else if(Character.isLowerCase(c))
              {
              hasLow = true;
              }
      if(hasNum && hasCap && hasLow)
      {
          return true;
      }
    }
      return false;
              
      
        
    
    }
    
    public static boolean checkUsername(String username) {
    return username.contains("_") && username.length()>=5;
    
    }
            
    
}

