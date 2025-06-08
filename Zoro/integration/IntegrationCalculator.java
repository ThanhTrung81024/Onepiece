package hus.oop.integration;

public class IntegrationCalculator {
    private MyIntegrator integrator;
    private MyPolynomial poly;

    public IntegrationCalculator(MyPolynomial poly) {
        this.poly = poly;
        this.integrator = null;
    }

    public IntegrationCalculator(MyIntegrator integrator, MyPolynomial poly) {
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(MyPolynomial poly) {
        this.poly = poly;
    }

    public void setIntegrator(MyIntegrator integrator) {
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        if (poly == null) {
            throw new IllegalStateException("Đa thức chưa được khởi tạo!");
        }
        if (integrator == null) {
            throw new IllegalStateException("Phương pháp tính tích phân chưa được khởi tạo!");
        }
        return integrator.integrate(poly, lower, upper);
    }
}
