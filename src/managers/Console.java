package managers;

import commands.ExecuteScript;
import errors.NoElementException;
import errors.UnknownCommandException;
import errors.UnknownElementException;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


public class Console {
    private CollectionManager collectionManager;

   private static String filename;

    /**
     *  Метод для установки названия файла
     * @param filename название файла
     */

   public void setFilename(String filename){
       this.filename = filename;
   }

    /**
     *
     * @param input ввод
     * @throws NoElementException ошибка при отсутствии элемента
     */
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
                    CommandManager.startExecuting(command, ExecuteScript.scripts);
                } catch (NoSuchElementException e) {
                    System.err.println("Ну вы так не делайте,(");
                    System.exit(1);
                } catch (UnknownCommandException e) {
                    System.err.println("Такой команды нет");;
                } catch (FileNotFoundException e) {
                    System.err.println(" Файл не существует");
                } catch (UnknownElementException e) {
                    System.err.println(" Такого элемента нет");
                }
            }
        }
    }
}
