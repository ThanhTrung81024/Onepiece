package hus.oop.integration;

public class MidpointRule implements MyIntegrator {
    private double precision;      // eps
    private int maxIterations;     // số lần phép chia đôi tối đa

    public MidpointRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Tính xấp xỉ giá trị tích phân bằng phương pháp điểm giữa.
     * Lặp với n = n0, 2n0, 4n0, ... (tôi chọn n0 = 1)
     * Dừng khi |I(2n) - I(n)|/3 < eps, hoặc khi đã chia đôi quá maxIterations lần.
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int iterations = 0;
        int n = 1;
        double I_n = integrate(polynomial, lower, upper, n);
        double I_2n;

        while (iterations < maxIterations) {
            n *= 2;
            I_2n = integrate(polynomial, lower, upper, n);
            // kiểm tra điều kiện hội tụ |I(2n)-I(n)|/3 < eps
            if (Math.abs(I_2n - I_n) / 3.0 < precision) {
                return I_2n;
            }
            // chưa hội tụ, tiếp tục với I_n mới
            I_n = I_2n;
            iterations++;
        }
        // quá số vòng, trả về kết quả cuối cùng
        return I_n;
    }

    /**
     * Tính xấp xỉ tích phân với numOfSubIntervals khoảng đều,
     * bằng công thức Midpoint: sum_{i=0..n-1} f(x_i + h/2) * h.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0.0;
        for (int i = 0; i < numOfSubIntervals; i++) {
            double xMid = lower + (i + 0.5) * h;
            sum += polynomial.evaluate(xMid);
        }
        return sum * h;
    }
}
