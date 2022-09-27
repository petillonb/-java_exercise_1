import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

class Freq implements Command {
    Freq() {
    }

    @Override
    public String name() {
        return "Freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        try {
            // System.out.println("Entrez un chemin de fichier...");
            String filepath = scanner.nextLine();
            try {
                Scanner scanner2 = new Scanner(new File(filepath));
                HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
                String firstword = null;

                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
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
                String result = "";
                for (int i = 0; i < 3; i++) {
                    String max = firstword;
                    for (String key : dictionary.keySet()) {
                        if (dictionary.get(max) < dictionary.get(key)) {
                            max = key;
                        }
                    }
                    int count = i + 1;
                    result += max;
                    if (i < 2) {
                        result += " ";
                    }
                    dictionary.remove(max);
                }
                System.out.println(result);

                scanner2.close();
                return false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return false;

        } catch (Exception exception) {
            System.err.println("Error: " + exception.toString());
            return true;
        }
    }
}