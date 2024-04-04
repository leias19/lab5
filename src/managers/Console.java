package managers;

import errors.NoElementException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;


public class Console {
    private CollectionManager collectionManager;

   private static String filename;

   public void setFilename(String filename){
       this.filename = filename;
   }
    public void start(InputStream input) throws NoElementException {
        Scanner scanner = new Scanner(input);
        CommandManager commandManager = new CommandManager();
        this.collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager();
        CollectionManager.setMap(Objects.requireNonNull(FileManager.readFile(filename)).getHuman());
        while (scanner.hasNextLine()){
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()){
                try {
                    CommandManager.startExecuting(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
