package java_exercise_2.src;

import java.util.Scanner;

class launcher {
    public static void main(String[] args) {
        System.out.println("Entrez text");
        Scanner objScan = new Scanner(System.in);
        String str1 = objScan.nextLine();
        if (str1.equals("quit") == true) {

        } else {
            System.out.println("Unknown command");
        }

    }
}