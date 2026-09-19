public class Matrix {

    private final int rows;
    private final int cols;
    private Complex[][] data;

    public Matrix(int rows, int cols){
        if (rows <= 0 || cols <= 0){
            throw new IllegalArgumentException("Not the correct size");
        }

        this.rows = rows;
        this.cols = cols;
        this.data = new Complex[rows][cols];
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
}
