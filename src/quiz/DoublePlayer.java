/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Mizunt
 */
public class DoublePlayer extends Computer {

   
   protected static String player1name=null;
   protected static String player2name=null;
    
public static void runQuiz() 
{   ///entering names of players
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter name of first player: ");
    player1name = scan.nextLine();
    System.out.print("Enter name of second player: ");
    player2name = scan.nextLine();
         try {
         inputStreamQuestion = new Scanner(new FileInputStream("questions.txt"));
         inputStreamAnswer = new Scanner (new FileInputStream("answers.txt"));
         }

         catch (FileNotFoundException e) 
         {
             System.out.println("Can't find the file.");
             System.exit(0);
         }
  
         
         System.out.println("\nEnter C to cheat or S to skip.");
         System.out.println("You will recieve 0 points if you cheat or skip.\n");
         // while there are still lines of questions to ask, this will run.
         while (inputStreamQuestion.hasNextLine()) 
         {
            String answer = null;
            line = inputStreamQuestion.nextLine();
            System.out.println("Question: The capital of " + line);
            answer = scan.nextLine();             
            
             
             if (answer.equals("C")|| answer.equals("c"))
             {
                line = inputStreamAnswer.nextLine();
                System.out.println("The answer is: " + line + "\n");
                scoreCount1 += 0;                
             }
             else if (answer.equals("S") || answer.equals("s")) {                   
                System.out.println("You've skipped this question.\n");
                line = inputStreamAnswer.nextLine();
                scoreCount1 += 0;
             }
             
        // makes user input answer uppercase and checks for equality with the answer from file
        // answer.txt
             else if (answer.toUpperCase().equals(inputStreamAnswer.nextLine())) {
                 System.out.println("Right answer!\n");
                 scoreCount1 += 1;                
             }
             else {
                 System.out.println("Wrong.\n");                
             }
             System.out.println("Please pass the game on to "+ player2name);
             
             //player will now be switched here
             
             line = inputStreamQuestion.nextLine();
             System.out.println("Question: The capital of " + line);
             answer = scan.nextLine();             
            
           
             if (answer.equals("C")|| answer.equals("c"))
             {
                line = inputStreamAnswer.nextLine();
                System.out.println("The answer is: " + line + "\n");
                scoreCount2 += 0;                
             }
             else if (answer.equals("S") || answer.equals("s")) {                   
                System.out.println("You've skipped this question.\n");
                line = inputStreamAnswer.nextLine();
                scoreCount2 += 0;
             }
             
        // makes user input answer uppercase and checks for equality with the answer from file
        // answer.txt
             else if (answer.toUpperCase().equals(inputStreamAnswer.nextLine())) {
                 System.out.println("Right answer!\n");
                 scoreCount2 += 1;                
             }
             else {
                 System.out.println("Wrong.\n");                
             }
             System.out.println("Please pass the game on to "+ player1name);
             }
             

             
             
             
             
             
             
             
                 
         
         inputStreamQuestion.close();
         inputStreamAnswer.close();
         totalScore1 = scoreCount1;
         totalScore2 = scoreCount2;
         
}

public static void player1ToString() {
     System.out.println("\nThe total score for "+ player1name + " is: " + getTotalScore());
}

public static void player2ToString() {
     System.out.println("The total score for "+ player2name + " is: " + getTotalScore2());
}
public static void compareScores()
{ 
    if (getTotalScore() > getTotalScore2())
        {
        System.out.println(player1name +" has won! Better luck next time " + player2name + ", you were no match for "
                + "the mighty " + player1name + " !");
        }
    else if(getTotalScore() == getTotalScore2())
    {
        System.out.println("Its a draw!");
    }
    else if (getTotalScore() < getTotalScore2())
        
            {
        System.out.println(player2name +" has won! Better luck next time " + player1name + ", you were no match for "
                + "the mighty " + player2name +" !");
        }
}

public static int eraseScore2() {
    return scoreCount2 = 0;
}
}

 
    
