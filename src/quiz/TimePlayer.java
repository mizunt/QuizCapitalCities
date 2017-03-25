/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mizunt
 */
public class TimePlayer extends Computer {
    
private static Timer time = new Timer();
private static int interval = 30;
private static Boolean timeBoolean = true;


    
public static void runQuiz() {
         

         try {
         inputStreamQuestion = new Scanner(new FileInputStream("questions.txt"));
         inputStreamAnswer = new Scanner (new FileInputStream("answers.txt"));
         
         }

         catch (FileNotFoundException e) {
             System.out.println("Can't find the file.");
             System.exit(0);
         }
  
         
 
        System.out.println("In the following quiz, enter C to cheat or S to skip.");
        System.out.println("You will recieve 0 points if you cheat or skip.\n");
        System.out.println("You will have 30 seconds to get as many points as possible.");
        System.out.println("Enter B to start. Goodluck.");
        boolean charBoolean = false;
        while(!charBoolean) {
            char userInput = scan.next().charAt(0);
            if (userInput == 'B' || userInput == 'b') {
                charBoolean = true; }
            else {
                System.out.println("Enter B to start.");
            }    

        }
             TimePlayer.Timer();
             scan.nextLine();
             while (inputStreamQuestion.hasNextLine() && timeBoolean) 
         {              
                String answer = null;
                line = inputStreamQuestion.nextLine();              
                
                System.out.println("Question: The capital of " + line);
                answer = scan.nextLine();

                if (answer.equals("C") || answer.equals("c")) {                  
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
                     
             }
             System.out.println("Times up!");
         
         
         inputStreamQuestion.close();
         inputStreamAnswer.close();
         totalScore1 = scoreCount1;
         }

    public static void Timer() {
        time.scheduleAtFixedRate(new TimerTask() {

    public void run() {
        if (interval == 1) {
            timeBoolean = false;
            time.cancel(); }    
        --interval;
    }

    }, 1000, 1000);
}


        

    

    

}
