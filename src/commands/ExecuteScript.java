package commands;

import data.*;
import errors.IncorrectInputException;
import errors.UnknownCommandException;
import errors.UnknownElementException;
import managers.CollectionManager;
import managers.CommandManager;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExecuteScript implements Command {
    public static Set<String> scripts = new HashSet<>();

    /**
     *  Метод для выполнения команды execute_script
     * @param args аргумент
     * @throws FileNotFoundException ошибка отсутствия файла
     */
    @Override
    public void execute(String[] args) throws FileNotFoundException {
        String file_path = args[1];

        Scanner scanner = new Scanner(new FileReader(file_path));
        try{
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.split(" ")[0].equals("insert")){
                    int id = Integer.parseInt(scanner.nextLine());
                    String name = scanner.nextLine();
                    int x = Integer.parseInt(scanner.nextLine());
                    long y = Long.parseLong(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(x, y);
                    boolean realHero = Boolean.parseBoolean(scanner.nextLine());
                    boolean hasToothpick = Boolean.parseBoolean(scanner.nextLine());
                    double impactSpeed = Double.parseDouble(scanner.nextLine());
                    String soundtrackName = scanner.nextLine();
                    WeaponType weaponType = WeaponType.valueOf(scanner.nextLine().toUpperCase());
                    Mood mood = Mood.valueOf(scanner.nextLine().toUpperCase());
                    String carName = scanner.nextLine();
                    boolean carCool = Boolean.parseBoolean(scanner.nextLine());
                    Car car = new Car(carName, carCool);

                    HumanBeing humanBeing = new HumanBeing(id);
                    humanBeing.setName(name);
                    humanBeing.setCoordinates(coordinates);
                    humanBeing.setRealHero(realHero);
                    humanBeing.setHasToothpick(hasToothpick);
                    humanBeing.setImpactSpeed(impactSpeed);
                    humanBeing.setSoundtrackName(soundtrackName);
                    humanBeing.setWeaponType(weaponType);
                    humanBeing.setMood(mood);
                    humanBeing.setCar(car);

                    CollectionManager.add(line.split(" ")[1],humanBeing);
                    System.out.println("элемент добавлен");
                    System.out.println("команда выполнена :)");
                }else{
                    CommandManager.startExecuting(line, scripts);
                }
            }
            System.out.println("команда выполнена :)");
        } catch (FileNotFoundException e) {
            System.out.println("нет такого файла");
        } catch (UnknownElementException e) {
            System.err.println("неизвестный элемент");
        } catch (UnknownCommandException | IncorrectInputException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("неизвестная ошибка");
        }
    }

    /**
     *  Метод для получения имени команды execute_script
     * @return имя
     */

    @Override
    public String getName() {
        return "execute_script file_name";
    }

    /**
     *  Метод для получения описания команды execute_script
     * @return описание
     */

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
