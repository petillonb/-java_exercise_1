import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;

class launcher {
    public static void main(String[] args) {
        Scanner objScan = new Scanner(System.in);
        System.out.println("Entrez text");
        String str1 = objScan.nextLine();
        while (str1.equals("quit") != true) {
            if (str1.equals("fibo") == true) {
                fibonachi(args);
            } else if (str1.equals("freq") == true) {
                freqence(args);
            } else {
                System.out.println("Unknown command");
            }
            System.out.println("Entrez commande");
            str1 = objScan.nextLine();
        }
        objScan.close();
    }
}

class fibo {
    public static void fibonachi(String[] args) {

        Scanner objScan = new Scanner(System.in);
        System.out.println("Entrez nombre");
        int str1 = objScan.nextInt();

        int f0 = 0;
        int f1 = 1;
        int res = 0;

        for (int i = 1; i < str1; i++) {
            res = f1 + f0;
            f0 = f1;
            f1 = res;
            System.out.println("i: " + i + " f0: " + f0 + " f1: " + f1);
        }
        System.out.println("fibo:" + res);

    }
}

class freq {
    public static void freqence(String[] args) {
        Scanner objScan = new Scanner(System.in);
        System.out.println("Entrez un chemin de fichier...");

        String filepath = objScan.nextLine();

        try {
            Scanner scanner = new Scanner(new File(filepath));
            Map<String, Integer> dictionary = new HashMap<String, Integer>();
            String firstword = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        objScan.close();

    }

}