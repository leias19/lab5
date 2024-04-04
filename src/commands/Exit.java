package commands;

public class Exit implements Command{
    @Override
    public void execute(String[] arg) {
        System.out.println("пока пока");
        System.exit(1);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
