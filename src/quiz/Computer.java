
package quiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;


public class Computer implements Serializable {
   
protected static String line = null;
protected static Scanner inputStreamQuestion = null;
protected static Scanner inputStreamAnswer = null;  
protected static int scoreCount1 = 0;
protected static int scoreCount2 = 0;
protected static int totalScore1 = 0;
protected static int totalScore2 = 0;
protected static int computerlevel=0;
protected static Scanner scan = new Scanner(System.in);
static final long serialVersionUID = 42L;


public static void runQuiz() 
{   ///entering names of players
    
    Scanner scan = new Scanner(System.in);
    
   

         try {
         inputStreamQuestion = new Scanner(new FileInputStream("questions.txt"));
         inputStreamAnswer = new Scanner (new FileInputStream("answers.txt"));
         }

         catch (FileNotFoundException e) 
         {
             System.out.println("Can't find the file.");
             System.exit(0);
         }
  
         
        
        System.out.println("In the following quiz, enter C to cheat or S to skip.");
        System.out.println("You will recieve 0 points if you cheat or skip.\n");
         
         // while there are still lines of questions to ask, this will run.
        while (inputStreamQuestion.hasNextLine()) 
         {   
             String answer = "";
             line = inputStreamQuestion.nextLine();
             System.out.println("Question: The capital of  " + line);
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

                System.out.println("The computer will now have a go");
                //player will now be switched here
                System.out.println("The computer is thinking...");
                int randomNumber = ((int)(Math.random() *13));
                if(randomNumber < computerlevel)
                    {
                        System.out.println("The computer has got it wrong\n");
                    }
                else 
                    {
                        System.out.println("The computer has got it correct\n");
                        scoreCount2 += 1;
             
                    }              
             }
         inputStreamQuestion.close();
         inputStreamAnswer.close();
         totalScore1 = scoreCount1;
         totalScore2 = scoreCount2;
             
         }

public static char setLevel()
{
    System.out.println("Please choose the level of difficulty for the game");
    System.out.println("Type E - for easy");
    System.out.println("Type M - for medium difficulty");
    System.out.println("Type H - for hard");
    Scanner scan = new Scanner(System.in);
    char level=scan.next().charAt(0);
    switch(level)
    {
        case 'e': 
            System.out.println("You've chosen the easy level");
            computerlevel=9;
            break;
        case 'm': 
            System.out.println("You've chosen the medium level");
            computerlevel=6;
            break;
         case 'h': 
            System.out.println("You've chosen the hard level");
            computerlevel=3; 
            
    }
    return level;
    
}

public static int eraseScore() {
    return scoreCount1 = 0;
}


public static int getScore () {
    return scoreCount1;
}

public static int getScore2 () {
    return scoreCount2;
}

public static int getTotalScore () {
    return totalScore1;
}

public static int getTotalScore2 () {
    return totalScore2;
}

public static void compareScores()
{ 
    if (getTotalScore() < getTotalScore2())
        {
        System.out.println("The computer has won!");
        }
    else
    {
        System.out.println("You have won!");
    }
        
}
public static void printTotalScore () {
        System.out.println("Your total score is " + totalScore1 + ".\n ");
}

}
        



    
    


