public class Complex {

    private double real;
    private double imaginary;

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(Complex other){
        real += other.getReal();
        imaginary += other.getImaginary();
    }

    public void subtract(Complex other){
        real -= other.getReal();
        imaginary -= other.getImaginary();
    }

    public void multiply(Complex other){
        double newReal = real*other.getReal() - imaginary*other.getImaginary();
        double newImaginary = real*other.getImaginary() + imaginary*other.getReal();
        real = newReal;
        imaginary = newImaginary;
    }

    @Override
    public String toString(){
        if (imaginary > 0) {
            return real + "+" + imaginary + "i";
        }

        if (imaginary < 0) {
            return real + "-" + imaginary + "i";
        }

        return String.valueOf(real);
    }

}
