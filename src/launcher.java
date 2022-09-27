import java.util.Scanner;

class launcher {
    public static void main(String[] args) {

        Scanner objScan = new Scanner(System.in);
        System.out.println("Entrez text");
        String str1 = objScan.nextLine();
        while (str1.equals("quit") != true) {
            System.out.println("Unknown command");
            System.out.println("Entrez text");
            str1 = objScan.nextLine();

        }

    }
}
