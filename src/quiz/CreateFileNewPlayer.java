/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author hamzaalfadel
 */
public class CreateFileNewPlayer {
    
    private static Player newPlayer = new Player();   
    private static boolean match = false;
    private static WriteRead newLoader = new WriteRead();
    private static int i = 0;
    private static ReadWrite newSaver = new ReadWrite();
    
    public static void registerUser() {
            newLoader.loadFile();
            
            boolean repeat = false; 
            int m;
            int arrayLength = newLoader.stuff.size();
            boolean usernameMatch = false;
            // System.out.println(arrayLength);
            
            // for (Player users : newLoader.stuff)
            // System.out.print(users + " ");
            
            while (!repeat) {
                usernameMatch = false;
                newPlayer.registerPlayer();
                // checking the array list to see whether the same user name already exists
                for (m = 0; m < arrayLength ; m++) {
                    if ((newPlayer.getName().equals(newLoader.stuff.get(m).getName()))) {
                        usernameMatch = true;
                    }
                }
                if (usernameMatch) {
                    System.out.println("User already exists. Try another username."); }
                
                else if (!usernameMatch) {
                    System.out.println("Creating new user...\n");
                    repeat = true;
                    // adding the new Player object to the array list of existing users
                    newLoader.stuff.add(0, newPlayer);
                    newSaver.SaveFile(newLoader.stuff);
                }
                
                    }          
            }
    


    
    public static void playGame() {
        
            Computer.setLevel();
            Computer.runQuiz();
            Computer.eraseScore();

           
    }
    public static void leaderBoard() {
            
            newLoader.stuff.get(0).getArrayScore();
            newLoader.stuff.get(0).printScoreBoard();
    }
    
    public static void playTimeGame() {
            TimePlayer.runQuiz();
            TimePlayer.printTotalScore();
            TimePlayer.eraseScore();

    }
    public static void playGameComputer() {
        
            Computer.setLevel();
            Computer.runQuiz();
            Computer.getTotalScore();
            Computer.getTotalScore2();
            Computer.compareScores();
                   
    }
     public static void playGameTen() {
        
            
            TenPlayer.runQuiz();
            TenPlayer.printTotalScore();

            // adding the user's total score from the recently played game to their array of scores
            // added to the index zero as all new Player objects are added at index zero
            
            newLoader.stuff.get(0).addArrayScore(Computer.getTotalScore());

            // creating outputstream to the file players.ser
            // writing the ArrayList object stuff to the binary file
            newSaver.SaveFile(newLoader.stuff);
            // reseting the total score to zero
            TenPlayer.eraseScore();
    }
      public static void playGameDouble() {
        
            
            DoublePlayer.runQuiz();
            DoublePlayer.player1ToString();
            DoublePlayer.player2ToString();
            DoublePlayer.compareScores();
                   
    }       
     
}
