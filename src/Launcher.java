import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

interface Command {
    public String name();

    public boolean run(Scanner var1);
}

class Launcher {
    Launcher() {
    }

    public static void main(String[] arrstring) {
        Command[] arrcommand = new Command[] { new Fibo(), new Freq(), new Quit() };
        List<Command> list = Arrays.asList(arrcommand);
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean continueLoop = true;
        System.out.println("Entrez commande");
        while (continueLoop) {
            input = scanner.nextLine();
            if (input != null && input.length() > 0) {
                boolean unknowCommand = true;
                for (Command command : list) {
                    if (input.equalsIgnoreCase(command.name())) {
                        continueLoop = !command.run(scanner);
                        unknowCommand = false;
                        break;
                    }
                }
                if (unknowCommand) {
                    System.out.println("Unknown command");
                }
            }
        }
        scanner.close();

    }
}