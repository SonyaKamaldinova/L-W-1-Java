public class Complex {

    private double real;
    private double imaginary;

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    public Complex negate(){
        return new Complex(-real, -imaginary);
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

    public Complex divide(Complex other){
        double denominator = other.getReal()*other.getReal() + other.getImaginary()*other.getImaginary();
        if (denominator == 0) {
            throw new ArithmeticException("Divided on null");
        }
        return new Complex((real * other.real + imaginary * other.imaginary) / denominator,
                (imaginary * other.real - real * other.imaginary) / denominator);
    }

    public double abs(){
        return Math.pow(real*real + imaginary*imaginary, 0.5);
    }

    public static Complex parse(String input){
        input = input.trim().replace(" ", "");
        if (!input.contains("i")){
            input = input.trim().replace("i", "");
            return new Complex(Double.parseDouble(input), 0);
        }
        input = input.trim().replace("i", "");
        int signIndex = -1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                signIndex = i;
                break;
            }
        }
        if (signIndex == -1) {
            double imaginary;
            if (input.equals("i")) {
                imaginary = 1;
            } else if (input.equals("-i")) {
                imaginary = -1;
            } else {
                imaginary = Double.parseDouble(input);
            }
            return new Complex(0, imaginary);
        }
        double real = Double.parseDouble(input.substring(0, signIndex));
        String imaginaryPart = input.substring(signIndex);
        double imaginary;
        if (imaginaryPart.equals("+")){
            imaginary = 1;
        }
        else if (imaginaryPart.equals("-")){
            imaginary = -1;
        }
        else {
            imaginary = Double.parseDouble(imaginaryPart);
        }
        return new Complex(real, imaginary);
    }

    @Override
    public String toString(){
        if (imaginary > 0) {
            return real + "+" + imaginary + "i";
        }

        if (imaginary < 0) {
            return real + "" + imaginary + "i";
        }
        return String.valueOf(real);
    }

}
