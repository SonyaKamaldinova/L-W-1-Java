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
        boolean running = true;
        while (running){
            System.out.println("Choose the option");
            int optAct = scanner1.nextInt();
            switch (optAct){
                case 0:
                    running = false;
                    System.exit(0);

                case 1:
                    Matrix result1 = A.add(B);
                    System.out.println("A + B:");
                    result1.print();
                    break;

                case 2:
                    Matrix Bn = new Matrix(B.getRows(), B.getCols());
                    for (int i = 0; i < B.getRows(); i++) {
                        for (int j = 0; j < B.getCols(); j++){
                            Bn.set(i, j, B.get(i, j).negate());
                        }
                    }
                    Matrix result2 = A.add(Bn);
                    System.out.println("A - B:");
                    result2.print();
                    break;

                case 3:
                    Matrix result3 = A.multiply(B);
                    System.out.println("A * B:");
                    result3.print();
                    break;

                case 4:
                    Complex determinantA = A.determinant();
                    Complex determinantB = B.determinant();
                    System.out.println("det(A) = " + determinantA);
                    System.out.println("det(B) = " + determinantB);
                    break;

                case 5:
                    Matrix inverseA = A.inverse();
                    Matrix inverseB = B.inverse();
                    System.out.println("A^-1:");
                    inverseA.print();
                    System.out.println("B^-1:");
                    inverseB.print();
                    break;

                case 6:
                    Matrix result6 = A.divide(B);
                    System.out.println("A / B:");
                    result6.print();
                    break;

                case 7:
                    Matrix transposedA = A.transpose();
                    Matrix transposedB = B.transpose();
                    System.out.println("A^T:");
                    transposedA.print();
                    System.out.println("B^T:");
                    transposedB.print();
                    break;

                case 8:
                    A.print();
                    B.print();
                    break;

                default:
                    System.out.println("Do not have this option");
                    running = false;
                    System.exit(1);
            }
        }
    }

}
