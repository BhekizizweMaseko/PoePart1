/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgela.poepart1;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Comfee
 */
public class LogIn {
    
String firstName;
 String lastName;
 String userName = null;
 String password = null:
 
 public void setFirstName(String Fname)
 {firstName = Fname;}
 public void setLastName(String Lname)
 {lastName = Lname;}
 public void setUserName(String Uname)
 {userName = Uname;}
 public void setPassword(String Pword)
 {password = Pword;}
 
 public String getFirstName()
 { return firstName;}
 public String getLastName()
 {return lastName;}
 public String getUserName()
 {return userName;}
 public String getPassword()
 {return password;}
 
 
 public boolean checkUserName(String userName) {
 return userName.contains("_") && userName.length() <= 5;
 }
 
 
 public boolean checkPasswordComplexity(String password){
 boolean containsACapitalLetter = false;
 boolean containsADigit = false;
 
 
 
 Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\s]");
 Matcher matcher = pattern.matcher(password);
 
 
 
 for(int i = 0; i < password.length(); i++){
 if(Character.isUpperCase(password.charAt(i)))
 {containsACapitalLetter = true;}
 
 }
 
 for(int i = 0; i < password.length(); i++){
 if(Character.isDigit(password.charAt(i)))
 containsADigit = true;
 
 }
 
 return(matcher.find()&& password.length()>=8 && containsACapitalLetter && 
containsADigit);
 
 
}
 
 public String registerUser(String userName, String password){
 
 boolean usableUserName = checkUserName(userName);
 boolean usablePassword = checkPasswordComplexity(password);
 
 if (usableUserName && usablePassword){
 return "Account successfully registered."; }
 
 else if(!usableUserName ){
 return "Username is formatted incorrectly"; 
 }
 else if(!usablePassword ){
 return "Password does not meet specifications";
 }
 return"";
 }
 
 public boolean loginUser(String userName1, String password1){
 
 
 return( userName1.equals(userName) && password1.equals(password)); }
 
 
 public String returnLoginStatus(boolean loginComplete){
 
 if(loginComplete) {
 return "Welcome " + firstName + " " + lastName + " ,its lovely to see you.<3";
 }
 else {
 return "Login unsuccesful.Username or password may be inncorrect,please try again.";
 }
 
 
}}
            
    


