
package quiz;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;



public class WriteRead implements Serializable {
    
    static final long serialVersionUID = 42L;
    public ArrayList<Player> stuff = new ArrayList<>();
    public ObjectInputStream load;
    
    public void loadFile() {
        
        
        try {
            FileInputStream loadFile = new FileInputStream("players.ser");
            load = new ObjectInputStream(loadFile);
            
            stuff = (ArrayList) load.readObject();
            load.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Something went wrong. The file to save your data was not found.");
        }
        catch (ClassNotFoundException a) {
            System.out.println("Class not found.");
        }
        catch (IOException ex) {
            System.out.println("There is an I/O error.");
        }
       
    }
}
