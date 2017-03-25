
package quiz;

import java.util.Scanner;


public class QuizDemo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String playerAnswer = "";
        String gameAnswer = "";
        String leaderboardAnswer = "";
        String notInterested = "Well, it seems you don't want to do anything. Don't worry we all feel that way sometimes. See you next time!";
        boolean correctInput = false;
        boolean newGameInput = false;
    while (!correctInput) {
        System.out.println("Are you a new player?");
        playerAnswer = scan.nextLine();
        if (playerAnswer.equals("yes") || playerAnswer.equals("Yes")) {
            correctInput = true;
            CreateFileNewPlayer.registerUser();
            while (!newGameInput) {
                scan.nextLine();
                System.out.println("Would you like to play a new game?");             
                gameAnswer = scan.nextLine();
                if (gameAnswer.equals("yes") || gameAnswer.equals("Yes")) { 
                    boolean gameType = false;
                    
                    while (!gameType) {
                        System.out.println("Select a to play out of ten to score on the leader board.");
                        System.out.println("Select c to play against a computer.");
                        System.out.println("select f to play against a friend.");
                        System.out.println("Select t to play against the clock.");                        
                        char play = scan.next().charAt(0);
                        switch (play)
                        {
                        case 'a': 
                            CreateFileNewPlayer.playGameTen();
                            gameType = true;
                            break;
                        case 'c': 
                            CreateFileNewPlayer.playGameComputer();
                            gameType = true;
                            break;
                        case 'f': 
                            CreateFileNewPlayer.playGameDouble();
                            gameType = true;
                            break;
                        case 't':
                            CreateFileNewPlayer.playTimeGame();
                            gameType = true;
                            break;                            
                        
                        }
                        }
                    }
                else if (gameAnswer.equals("no") || gameAnswer.equals("No")) {
                    // breaks the 'true' while loop for playing a new game.                      
                    break; }

            }
  
            boolean leaderboardInput = false;
            while (!leaderboardInput) {
                System.out.println("Would you like to view your personal leaderboard?");
                leaderboardAnswer = scan.nextLine();
                if (leaderboardAnswer.equals("Yes") || leaderboardAnswer.equals("yes")) {
                    
                    CreateFileNewPlayer.leaderBoard();
                    leaderboardInput = true; }
                else if (leaderboardAnswer.equals("No") || leaderboardAnswer.equals("no")) {
                    System.out.println(notInterested);
                    leaderboardInput = true;
                    System.exit(0); }
                else {
                    leaderboardInput = false;
                     }
                    }
                }
            
        
    
        
        else if (playerAnswer.equals("no") || playerAnswer.equals("No")) {
            correctInput = true;
            CreateFileOldPlayer.verifyUser();
            
            while (true) {
                scan.nextLine();
                System.out.println("Would you like to play a new game?");
                gameAnswer = scan.nextLine();
                if (gameAnswer.equals("yes") || gameAnswer.equals("Yes")) {                  
                    boolean gameType = false;
                    while (!gameType) {
                
                        System.out.println("Select a to play out of ten to score on the leader board.");
                        System.out.println("Select c to play against a computer.");
                        System.out.println("Select f to play against a friend.");
                        System.out.println("Select t to play against the clock.");
                        char play = scan.next().charAt(0);
                        switch (play)
                        {
                        case 'a': 
                            CreateFileOldPlayer.playGameTen();
                            gameType = true;
                            break;
                        case 'c': 
                            CreateFileOldPlayer.playGameComputer();
                            gameType = true;
                            break;
                        case 'f': 
                            CreateFileOldPlayer.playGameDouble();
                            gameType = true;
                            break;
                        case 't':
                            CreateFileOldPlayer.playTimeGame();
                            gameType = true;
                            break;                            
                                                    
                        }
                    }
                }
                else if (gameAnswer.equals("no") || gameAnswer.equals("No"))
                    break; }
            boolean leaderboardInput = false;
            while(!leaderboardInput) {  
                System.out.println("Would you like to view your personal leaderboard?");
                leaderboardAnswer = scan.nextLine();
                if (leaderboardAnswer.equals("Yes") || leaderboardAnswer.equals("yes")) {
                    System.out.println("Here are your scores ranked in descending order:");
                    CreateFileOldPlayer.leaderBoard();
                    leaderboardInput = true; }
                else if (leaderboardAnswer.equals("No") || leaderboardAnswer.equals("no")) {
                    System.out.println(notInterested);
                    System.exit(0); }
            }
        }
    }
            
        }
    }
        
    



