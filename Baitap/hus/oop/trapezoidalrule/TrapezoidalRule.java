package hus.oop.trapezoidalrule;

public class TrapezoidalRule {
    public static void main (String[] args) {
        double epsilon = 1e-6;  // Độ chính xác
        double integral = integrate();
        System.out.printf("Trapezoidal Rule: %.6f\n", integral);
        System.out.printf("Java Library: %.6f\n" , Math.pow(Math.sin(Math.PI / 2), 3) / 3);
    }
    
    public static double f(double x) {
        return Math.sin(x) * Math.sin(x) * Math.cos(x);
    }
    
    public static double integrate(int n) {
        double a = 0;
        double b = Math.PI / 2;
        double h = (b - a) / n;
        double sum = 0.5 * (f(a) + f(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += f(x);
        }
        return sum * h;
    }
    
    public static double integrate() {
        double epsilon = 1e-6;  // Độ chính xác
        int n = 2;
        double ln = integrate(n);
        while (true) {
            int nextN = 2 * n;
            double l2n = integrate(nextN);
            if (Math.abs(l2n - ln) < epsilon) {
                return l2n;
            }
            ln = l2n;
            n = nextN;
        }
    }
}