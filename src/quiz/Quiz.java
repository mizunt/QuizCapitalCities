
package quiz;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
        
public class Quiz {
    
private String line = null;
private String answer = null;
private Scanner inputStreamQuestion = null;
private Scanner inputStreamAnswer = null;  
private static int scoreCount = 0;
private int totalScore = 0;
    
public void runQuiz() {

         try {
         inputStreamQuestion = new Scanner(new FileInputStream("question.txt"));
         inputStreamAnswer = new Scanner (new FileInputStream("answer.txt"));
         }

         catch (FileNotFoundException e) {
             System.out.println("Can't find the file.");
             System.exit(0);
         }
  
         Scanner scan = new Scanner(System.in);
         // while there are still lines of questions to ask, this will run.
         while (inputStreamQuestion.hasNextLine()) {
             line = inputStreamQuestion.nextLine();
             System.out.println("Question: " + line);
             answer = scan.nextLine();
        // makes user input answer uppercase and checks for equality with the answer from file
        // answer.txt
             if (answer.toUpperCase().equals(inputStreamAnswer.nextLine())) {
                 System.out.println("Right answer!");
                 this.scoreCount += 1;
                 
             }
             else {
                 System.out.println("Wrong.");             
             }
                 
         }
         inputStreamQuestion.close();
         inputStreamAnswer.close();
         this.totalScore = this.scoreCount;
         
}
public int getScore () {
    return this.scoreCount;
}

public int getTotalScore () {
    return this.totalScore;
}

        }