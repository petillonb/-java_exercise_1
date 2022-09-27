import java.util.Scanner;

class Fibo implements Command {
    Fibo() {
    }

    @Override
    public String name() {
        return "Fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        try {
            System.out.println("Entrez nombre");
            int n = scanner.nextInt();
            int n2 = 0;
            int n3 = 1;
            int n4 = 0;
            for (int i = 1; i < n; ++i) {
                n4 = n3 + n2;
                n2 = n3;
                n3 = n4;
            }
            System.out.println(n4);
            return false;
        } catch (Exception exception) {
            System.err.println("Error: " + exception.toString());
            return true;
        }
    }
}