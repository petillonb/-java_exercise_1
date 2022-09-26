import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

interface Command {
    public String name();

    public boolean run(Scanner scanner);
}

class Fibo implements Command {
    public String name() {
        return "fibo";
    }

    public boolean run(Scanner scanner) {
        try {
            System.out.println("Entrez nombre");
            int str1 = scanner.nextInt();

            int f0 = 0;
            int f1 = 1;
            int res = 0;

            for (int i = 1; i < str1; i++) {
                res = f1 + f0;
                f0 = f1;
                f1 = res;
            }
            System.out.println("fibo(" + str1 + ") = " + res);
            return false;
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
            return true;
        }
    }
}

class Freq implements Command {
    public String name() {
        return "freq";
    }

    public boolean run(Scanner scanner) {

        try {
            System.out.println("Entrez un chemin de fichier...");

            String filepath = scanner.nextLine();

            try {
                Scanner filescanner = new Scanner(new File(filepath));
                Map<String, Integer> dictionary = new HashMap<String, Integer>();
                String firstword = null;

                while (filescanner.hasNextLine()) {
                    String line = filescanner.nextLine();
                    String[] words = line.replaceAll("\n", "").replaceAll("[.,?!;&:]", "").split(" ");

                    for (String word : words) {
                        if (firstword == null) {
                            firstword = word;
                        }
                        if (dictionary.containsKey(word) == true) {
                            int val = dictionary.get(word);
                            dictionary.replace(word, val + 1);
                        } else {
                            dictionary.put(word, 1);
                        }
                    }
                }

                for (int i = 0; i < 3; i++) {
                    String max = firstword;
                    for (String key : dictionary.keySet()) {
                        if (dictionary.get(max) < dictionary.get(key)) {
                            max = key;
                        }
                    }
                    int count = i + 1;
                    System.out.println(
                            "Top " + count + " word is " + max + " with " + dictionary.get(max) + " occurrences !");
                    dictionary.remove(max);
                }

                filescanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
            return true;
        }

    }
}

class Quit implements Command {
    public String name() {
        return "quit";
    }

    public boolean run(Scanner scanner) {
        return true;
    }
}

class refact {
    public static void main(String[] args) {
        Command[] cmds = new Command[] {
                new Fibo(), new Freq(), new Quit() };
        List<Command> commands = Arrays.asList(cmds);

        Scanner scanner = new Scanner(System.in);
        String user_input = "";
        boolean continueLoop = true;
        while (continueLoop) {

            System.out.println("Entrez commande");
            user_input = scanner.nextLine();
            boolean cmdUnknown = true;
            for (Command command : commands) {
                if (user_input.equalsIgnoreCase(command.name())) {
                    continueLoop = !command.run(scanner);
                    cmdUnknown = false;
                    break;
                }
            }
            if (cmdUnknown) {
                System.out.println("Unknown command");
            }
        }
        scanner.close();
    }
}