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
                        data[i][j] = Complex.parse(input);
                    }
                }
                B = new Matrix(data);
                System.out.println("Matrix B created!");
                break;

            default:
                System.out.println("Do not have this option");
                System.exit(1);
        }
        boolean running = true;
        while (running){
            System.out.println("Choose the option");
            System.out.println("0 - Exit");
            System.out.println("1 - A + B");
            System.out.println("2 - A - B");
            System.out.println("3 - A * B");
            System.out.println("4 - Determinant");
            System.out.println("5 - Inverse matrix");
            System.out.println("6 - A / B");
            System.out.println("7 - Transpose");
            System.out.println("8 - Print");
            System.out.println("9 - Multiplied by the number");
            System.out.println("10 - Change A");
            System.out.println("11 - Change B");
            int optAct = scanner1.nextInt();
            switch (optAct){
                case 0:
                    running = false;
                    System.exit(0);

                case 1:
                    System.out.println("A + B:");
                    A.add(B).print();
                    break;

                case 2:
                    Matrix Bn = new Matrix(B.getRows(), B.getCols());
                    for (int i = 0; i < B.getRows(); i++) {
                        for (int j = 0; j < B.getCols(); j++){
                            Bn.set(i, j, B.get(i, j).negate());
                        }
                    }
                    System.out.println("A - B:");
                    A.add(Bn).print();
                    break;

                case 3:
                    System.out.println("A * B:");
                    A.multiply(B).print();
                    break;

                case 4:
                    System.out.println("det(A) = " + A.determinant());
                    System.out.println("det(B) = " + B.determinant());
                    break;

                case 5:
                    System.out.println("A^-1:");
                    A.inverse().print();
                    System.out.println("B^-1:");
                    B.inverse().print();
                    break;

                case 6:
                    System.out.println("A / B:");
                    A.divide(B).print();
                    break;

                case 7:
                    System.out.println("A^T:");
                    A.transpose().print();
                    System.out.println("B^T:");
                    B.transpose().print();
                    break;

                case 8:
                    System.out.println("A:");
                    A.print();
                    System.out.println("B:");
                    B.print();
                    break;

                case 9:
                    System.out.println("Number in format 'a+bi':");
                    String input = scanner2.nextLine();
                    Complex num = Complex.parse(input);
                    System.out.println("n * A:");
                    A.multiply(num).print();
                    System.out.println("n * B:");
                    B.multiply(num).print();
                    break;

                case 10:
                    Complex[][] dataA = new Complex[A.getRows()][A.getCols()];
                    System.out.println("Values in format 'a+bi':");
                    for (int i = 0; i < A.getRows(); i++) {
                        for (int j = 0; j < A.getCols(); j++) {
                            String inputA = scanner2.nextLine();
                            dataA[i][j] = Complex.parse(inputA);
                        }
                    }
                    A = new Matrix(dataA);
                    System.out.println("Matrix changed!");
                    break;

                case 11:
                    Complex[][] dataB = new Complex[B.getRows()][B.getCols()];
                    System.out.println("Values in format 'a+bi':");
                    for (int i = 0; i < B.getRows(); i++) {
                        for (int j = 0; j < B.getCols(); j++) {
                            String inputB = scanner2.nextLine();
                            dataB[i][j] = Complex.parse(inputB);
                        }
                    }
                    B = new Matrix(dataB);
                    System.out.println("Matrix changed!");
                    break;

                default:
                    System.out.println("Do not have this option");
                    running = false;
                    System.exit(1);
            }
        }
    }
}
