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
public class CreateFileOldPlayer {
    

    private static Player oldPlayer = new Player();   
    private static boolean match = false;
    private static WriteRead newLoader = new WriteRead();
    private static int i = 0;
    private static ReadWrite newSaver = new ReadWrite();
    
    public static void verifyUser() {
            while (!match) {
                oldPlayer.verifyPlayer();
                newLoader.loadFile();
                int stuffSize = newLoader.stuff.size();

                for (i = 0; i < stuffSize; i++) {
                    if (oldPlayer.getName().equals(newLoader.stuff.get(i).getName()) &&
                       (oldPlayer.getPassword().equals(newLoader.stuff.get(i).getPassword()))) {
                        System.out.println("Correct!");
                        for (Player players : newLoader.stuff) {
                            //System.out.print(players);
                        }
                        match = true;
                        break;      
                }           
            }
                if (!match) {
                    System.out.println("Wrong input.");
                }
            }
                
            System.out.println("Signing in...");
            
        }
    public static void playGame() {
                Computer.setLevel();
                Computer.runQuiz();
                Computer.printTotalScore();
                Computer.eraseScore();

                        
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
            // added to the index i as this was the index where there was a match for username/password
            // in the initial player verification. Hence this user is 'signed in'.
            
            newLoader.stuff.get(i).addArrayScore(Computer.getScore());

            // creating outputstream to the file players.ser
            // writing the ArrayList object stuff to the binary file
            newSaver.SaveFile(newLoader.stuff);
            TenPlayer.eraseScore();
    }
      public static void playGameDouble() {
        
            
            DoublePlayer.runQuiz();
            DoublePlayer.player1ToString();
            DoublePlayer.player2ToString();
            DoublePlayer.compareScores();
            
            // setting the score instace variable in newPlayer to the score from the game
            //newPlayer.addArrayScore(DoublePlayer.getScore());
            // adding newPlayer object to the public ArrayList<NewPlayer> located in WriteRead class
        
           // newLoader.stuff.add(0, newPlayer);
            // creating outputstream to the file players.ser
            // writing the ArrayList object stuff to the binary file
            //newSaver.SaveFile(newLoader.stuff);                       
    }       
     
    
    public static void leaderBoard() {
        
             newLoader.stuff.get(i).getArrayScore();
             //newLoader.stuff.get(i).printScoreBoard();
    }
    
    
      public static int geti()
      {
       return i;
      }
      
      public static WriteRead getLoader()
      {
       return newLoader;   
      }
      
              
    }
