/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author Mizunt
 */
public class TenPlayer extends Computer {


private static String question = "";
private static int random = 0;
private static int count = 0;
private static List<String> questionList = new ArrayList<String>();
private static List<String> answerList = new ArrayList<String>();
private static String answerLine = "";

    
public static void runQuiz() {
        

        

        try {
        BufferedReader readerQuestion = new BufferedReader(new FileReader("questions.txt"));
        String lineQ = readerQuestion.readLine();
        BufferedReader readerAnswer = new BufferedReader(new FileReader("answers.txt"));
        String lineA = readerAnswer.readLine();
        
        while (lineQ != null) {
            questionList.add(lineQ);
            lineQ = readerQuestion.readLine();
        }
        while (lineA != null) {
            answerList.add(lineA);
            lineA = readerAnswer.readLine();
        }
        }      
        
        catch (FileNotFoundException e) {
             System.out.println("Can't find the file.");
             System.exit(0); 
        }
        catch (IOException e) {
            System.out.println("There is an I/O error.");
        }
        
        System.out.println("In the following quiz you will be asked 10 random questions");
        System.out.println("Enter C to cheat or S to skip a question.");
        System.out.println("You will recieve 0 points if you cheat or skip.\n");
        
        
        for (count = 0; count < 11; count ++) {
            random = (int)((Math.random()*questionList.size()));
            question = questionList.get(random);
            String answer = null;
            System.out.println("Question: The capital of " + question);
            answer = scan.nextLine();
            if (answer.equals("C") || answer.equals("c")) {                                  
                System.out.println("The answer is: " + answerList.get(random) + "\n");
                scoreCount1 += 0;
                }
            else if (answer.equals("S") || answer.equals("s")) {                   
                System.out.println("You've skipped this question.\n");
                scoreCount1 += 0;
                }
                // makes user input answer uppercase and checks for equality with the answer from file
                // answers.txt
            else if (answer.toUpperCase().equals(answerList.get(random))) {
                System.out.println("Right answer!\n");
                scoreCount1 = scoreCount1 + 1;      
                }                    
                
            else {
                System.out.println("Wrong.\n");
                }    
                         
        }
        
        totalScore1 = scoreCount1;
/*
         try {
         inputStreamQuestion = new Scanner(new FileInputStream("questions.txt"));
         inputStreamAnswer = new Scanner (new FileInputStream("answers.txt"));
         
         }

         catch (FileNotFoundException e) {
             System.out.println("Can't find the file.");
             System.exit(0);
         }
  
  */       
 

}


}
