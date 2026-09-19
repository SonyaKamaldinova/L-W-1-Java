public class Matrix {

    private int rows;
    private int cols;
    private Complex[][] data;

    public Matrix(int rows, int cols){
        if (rows <= 0 || cols <= 0){
            throw new IllegalArgumentException("Not the correct size");
        }

        this.rows = rows;
        this.cols = cols;
        this.data = new Complex[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                data[i][j] = new Complex(0, 0);
            }
        }
    }

    public Matrix(Complex[][] data){

    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Complex get(int row, int col){
        return data[row][col];
    }

    public void set(int row, int col, Complex value) {
        data[row][col] = value;
    }
}
