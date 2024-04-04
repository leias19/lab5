package managers;

import data.Mood;
import data.WeaponType;
import errors.IncorrectInputException;

public class Validator {
    public static void moreThanZero(String args) throws IncorrectInputException {
        try {
            int id = Integer.parseInt(args);
            if (id < 0) {
                throw new IncorrectInputException("id");
            }
        } catch (Exception e) {
            throw new IncorrectInputException("id");
        }
    }

    public static void coordinateXIsRight(String args) throws IncorrectInputException, NullPointerException {
        try {
            int x = Integer.parseInt(args);
            if (x > 5) {
                throw new IncorrectInputException("x");
            }
            throw new NullPointerException("x");
        } catch (Exception e) {
            throw new IncorrectInputException("x");
        }
    }

    public static void coordinateYIsRight(String args) throws IncorrectInputException, NullPointerException {
        try {
            long y = Long.parseLong(args);
            if (y > 503) {
                throw new IncorrectInputException("y");
            }
            throw new NullPointerException("y");
        } catch (Exception e) {
            throw new IncorrectInputException("y");
        }
    }

    public static void booleanNotNull(String args, String data) throws NullPointerException {
        try{
            Boolean value = Boolean.parseBoolean(args);
            throw new NullPointerException(data);
        }catch (Exception e){
            throw new NullPointerException(data);
        }
    }

    public static void booleanIsBoolean(String args, String data) throws IncorrectInputException {
        try{
            Boolean value = Boolean.parseBoolean(args);
            throw new IncorrectInputException(data);
        }catch (Exception e){
            throw new IncorrectInputException(data);
        }
    }

    public static boolean intIsInt(String args) throws IncorrectInputException {
        try{
            int value = Integer.parseInt(args);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static void doubleIsDouble(String args, String data) throws IncorrectInputException {
        try{
            double value = Double.parseDouble(args);
            throw new IncorrectInputException(data);
        }catch (Exception e){
            throw new IncorrectInputException(data);
        }
    }



    public static void moodIsRight(String args) throws IncorrectInputException {
        try {
            Mood.valueOf(args);
        } catch (Exception e) {
            throw new IncorrectInputException("Mood");
        }
    }

    public static void weaponTypeIsRight(String args) throws IncorrectInputException {
        try {
            WeaponType.valueOf(args);
        } catch (Exception e) {
            throw new IncorrectInputException("WeaponType");
        }
    }

    public static void inputIsNotEmpty(String args, String data) throws IncorrectInputException{
        if (args.isEmpty() || args.trim().isEmpty()) {
            throw new IncorrectInputException(data);
        }
    }


}
