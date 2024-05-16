package managers;

import commands.ExecuteScript;
import errors.IncorrectInputException;
import errors.UnknownCommandException;
import errors.UnknownElementException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


public class Console {

   private static String filename;

    /**
     *  Метод для установки названия файла
     * @param filename название файла
     */

   public void setFilename(String filename){
       this.filename = filename;
   }

    /**
     *  Метод для запуска
     * @param input ввод
     */
    public void start(InputStream input) {
        Scanner scanner = new Scanner(input);
        new CommandManager();
        CollectionManager.setMap(Objects.requireNonNull(FileManager.readFile(filename)).getHuman());
        while (scanner.hasNextLine()){
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()){
                try {
                    CommandManager.startExecuting(command, ExecuteScript.scripts);
                } catch (NoSuchElementException e) {
                    System.err.println("Ну вы так не делайте,(");
                    System.exit(1);
                } catch (UnknownCommandException e) {
                    System.err.println("Такой команды нет");
                } catch (FileNotFoundException e) {
                    System.err.println("Файл не существует");
                } catch (UnknownElementException e) {
                    System.err.println("Такого элемента нет");
                } catch (IncorrectInputException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
