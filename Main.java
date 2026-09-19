import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the option");
        System.out.println("1 - Create null matrix");
        System.out.println("2 - Create matrix");
        int opt = scanner.nextInt();
        Matrix A = null;
        switch (opt){
            case 1:
                System.out.println("Rows:");
                int rows1 = scanner.nextInt();
                if (rows1 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                System.out.println("Cols:");
                int cols1 = scanner.nextInt();
                if (cols1 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                A = new Matrix(rows1, cols1);
                System.out.println("Matrix created!");
                break;

            case 2:
                System.out.println("Rows:");
                int rows2 = scanner.nextInt();
                if (rows2 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                System.out.println("Cols:");
                int cols2 = scanner.nextInt();
                if (cols2 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                A = new Matrix(rows2, cols2);
                System.out.println("Values in format 'a+bi':");
                System.out.println("Matrix created!");
                break;
        }

    }

}
