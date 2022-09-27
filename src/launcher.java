import java.util.Scanner;

class launcher {
    public static void main(String[] args) {

        Scanner objScan = new Scanner(System.in);
        System.out.println("Entrez text");
        String str1 = objScan.nextLine();
        while (str1.equals("quit") != true) {
            if (str1.equals("fibo") == true) {
                fibonachi(args);

            } else {
                System.out.println("Unknown command");

            }
            System.out.println("Entrez commande");
            str1 = objScan.nextLine();

        }

    }

}

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