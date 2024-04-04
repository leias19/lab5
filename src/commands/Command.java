package commands;
import errors.*;

import java.io.IOException;

public interface Command {
    public void execute(String[] arg) throws NoElementException, Exception;
    public String getName();
    public String getDescription();
}