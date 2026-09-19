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
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols){
                throw new IllegalArgumentException("Rows are not equal");
            }
            System.arraycopy(data[i], 0, this.data[i], 0 , cols);
        }
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

    public void print(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                System.out.print(data[i][j].toString() + " ");
            }
            System.out.println("");
        }
    }
    public Matrix add(Matrix other){
        if (rows != other.getRows() || cols != other.getCols()){
            throw new IllegalArgumentException("Matrices of different dimension");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                result.set(i, j, data[i][j].add(other.get(i, j)));
            }
        }
        return result;
    }

    public Matrix multipy(Matrix other){
        if (cols != other.getRows()){
            throw new IllegalArgumentException("Can not multipy");
        }

        Matrix result = new Matrix(rows, other.getCols());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < cols; k++) {
                    sum = sum.add(data[i][k].multiply(other.get(k, j)));
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }
}
