/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;


import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class Player implements Serializable {
    
    private String name;
    private String password;
    transient Scanner scan = new Scanner(System.in);
    static final long serialVersionUID = 42L;
    private ArrayList<Integer> scoreList = new ArrayList<>();   
    private static String IntegerString = " ";
   
public Player() {
    name = "null";
    password = "null";

}   

public Player(String theName, String thePassword) {
    this.name = theName;
    this.password = thePassword;

}


public void registerPlayer() {
    
    System.out.print("Enter a username: ");
    name = scan.nextLine();
    System.out.print("Enter a password: ");
    password = scan.nextLine();
   
    }

public void verifyPlayer() {
    System.out.print("Enter your username: ");
    name = scan.nextLine();
    System.out.print("Enter your password: ");
    password = scan.nextLine();
}


    public void addArrayScore(int k) {
        scoreList.add(k);
        
    }
    

 public void getArrayScore() {
        //System.out.print("Your scores, in order of when you played. Your most recent score being last: ");
        
        //for (Integer integers : scoreList) {
        //    System.out.print(integers + " "); }
       // System.out.println(" ");
       // System.out.print("Your scores in descending order:");
        
        Collections.sort(scoreList);
        Collections.reverse(scoreList);
        Integer k = 0;
        for (k = 0; k < scoreList.size(); k++) {
            IntegerString = IntegerString  + scoreList.get(k).toString() + " ";
        }
        System.out.println(IntegerString);
    }
    
 public static void printScoreBoard() {
     System.out.print(IntegerString);
 }
    
    public String getName( ) {
        return name;
    }
    public void setName(String aName) {
        this.name = aName;    
    }
    public void setPassword(String aPassword) {
        this.password = aPassword;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String toString() {
        return (name + " " + password + " " + scoreList);
    }
  
    
}
