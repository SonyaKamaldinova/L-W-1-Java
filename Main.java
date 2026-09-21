import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Choose the option");
        System.out.println("1 - Create null matrix A");
        System.out.println("2 - Create matrix A");
        int optA = scanner1.nextInt();
        Matrix A = null;
        switch (optA){
            case 1:
                System.out.println("Rows:");
                int rows1 = scanner1.nextInt();
                if (rows1 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                System.out.println("Cols:");
                int cols1 = scanner1.nextInt();
                if (cols1 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                A = new Matrix(rows1, cols1);
                System.out.println("Matrix A created!");
                break;

            case 2:
                System.out.println("Rows:");
                int rows2 = scanner1.nextInt();
                if (rows2 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                System.out.println("Cols:");
                int cols2 = scanner1.nextInt();
                if (cols2 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                Complex[][] data = new Complex[rows2][cols2];
                System.out.println("Values in format 'a+bi':");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        String input = scanner2.nextLine();
                        data[i][j] = Complex.parse(input);
                    }
                }
                A = new Matrix(data);
                System.out.println("Matrix created!");
                break;

            default:
                System.out.println("Do not have this option");
                System.exit(1);
        }

        System.out.println("Choose the option");
        System.out.println("1 - Create null matrix B");
        System.out.println("2 - Create matrix B");
        int optB = scanner1.nextInt();
        Matrix B = null;
        switch (optB){
            case 1:
                System.out.println("Rows:");
                int rows1 = scanner1.nextInt();
                if (rows1 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                System.out.println("Cols:");
                int cols1 = scanner1.nextInt();
                if (cols1 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                B = new Matrix(rows1, cols1);
                System.out.println("Matrix created!");
                break;

            case 2:
                System.out.println("Rows:");
                int rows2 = scanner1.nextInt();
                if (rows2 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                System.out.println("Cols:");
                int cols2 = scanner1.nextInt();
                if (cols2 == 0) {
                    throw new IllegalArgumentException("Not the correct size");
                }
                B = new Matrix(rows2, cols2);
                Complex[][] data = new Complex[rows2][cols2];
                System.out.println("Values in format 'a+bi':");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        String input = scanner2.nextLine();
                        try {
                            data[i][j] = Complex.parse(input);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Not the correct format!");
                        }
                    }
                }
                B = new Matrix(data);
                System.out.println("Matrix B created!");
                break;

            default:
                System.out.println("Do not have this option");
                System.exit(1);
        }
        int optAct = scanner1.nextInt();
        switch (optAct){
            case 0:
                System.exit(0);

            case 1:
                Matrix result = A.add(B);
                System.out.println("A + B:");
                System.out.println(result);

            default:
                System.out.println("Do not have this option");
                System.exit(1);


        }
    }

}
