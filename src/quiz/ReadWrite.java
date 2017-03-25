
package quiz;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;

public class ReadWrite implements Serializable {
    
    static final long serialVersionUID = 42L;
    public FileOutputStream saveFile = null;
    public ObjectOutputStream save = null;
    
    public void SaveFile(ArrayList players) {
        

        try {
            saveFile = new FileOutputStream("players.ser");
            save = new ObjectOutputStream(saveFile);
            
            save.writeObject(players);
            save.close();
            
        }
        
        catch (FileNotFoundException m) {
            System.out.println("Something went wrong. The file to save your data was not found.");
        }
        
        catch (IOException h) {
            System.out.println("There is an I/O error.");
        }
        
    }

}
