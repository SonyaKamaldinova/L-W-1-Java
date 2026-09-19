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

    public Complex add(Complex other){
        return new Complex(real += other.getReal(), imaginary += other.getImaginary());
    }

    public Complex subtract(Complex other){
        return new Complex(real -= other.getReal(), imaginary -= other.getImaginary());
    }

    public Complex multiply(Complex other){
        double newReal = real*other.getReal() - imaginary*other.getImaginary();
        double newImaginary = real*other.getImaginary() + imaginary*other.getReal();
        return new Complex(newReal, newImaginary);
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
