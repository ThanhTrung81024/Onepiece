package hus.oop.integration;

public class TrapezoidRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int iterations = 0;
        int n = 1;
        double I_n = integrate(polynomial, lower, upper, n);
        double I_2n;
        while (iterations < maxIterations) {
            n *= 2;
            I_2n = integrate(polynomial, lower, upper, n);
            if (Math.abs(I_2n - I_n) / 3.0 < precision) {
                return I_2n;
            }
            I_n = I_2n;
            iterations++;
        }
        return I_n;
    }

    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0.5 * (polynomial.evaluate(lower) + polynomial.evaluate(upper));
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            sum += polynomial.evaluate(x);
        }
        return sum * h;
    }
}
