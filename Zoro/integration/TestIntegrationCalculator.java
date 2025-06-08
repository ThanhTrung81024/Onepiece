package hus.oop.integration;

import java.util.Random;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        TestIntegrationCalculator tester = new TestIntegrationCalculator(new MyArrayPolynomial());
        tester.testArrayPolynomial();
        tester.testListPolynomial();
    }

    public void testArrayPolynomial() {
        Random random = new Random();
        int size = random.nextInt(5) + 1;
        MyArrayPolynomial poly = new MyArrayPolynomial();
        for (int i = 0; i < size; i++) {
            poly.append(random.nextDouble() * 10);
        }
        System.out.println("Đa thức gốc (ArrayPolynomial): " + poly);
        poly.append(1.23);
        System.out.println("Sau khi thêm 1.23: " + poly);
        poly.add(2.34, 1);
        System.out.println("Sau khi cộng 2.34 vào hệ số tại vị trí 1: " + poly);
        poly.set(5.67, 2);
        System.out.println("Sau khi đặt hệ số 5.67 tại vị trí 2: " + poly);
        MyArrayPolynomial p2 = new MyArrayPolynomial();
        size = random.nextInt(5) + 1;
        for (int i = 0; i < size; i++) {
            p2.append(random.nextDouble() * 5);
        }
        System.out.println("Đa thức thứ hai (ArrayPolynomial): " + p2);
        System.out.println("Tổng: " + poly.plus(p2));
        System.out.println("Hiệu: " + poly.minus(p2));
        System.out.println("Tích: " + poly.multiply(p2));
        double x = random.nextDouble() * 5;
        System.out.println("Giá trị tại x = " + x + ": " + poly.evaluate(x));
        IntegrationCalculator ic = new IntegrationCalculator(new TrapezoidRule(1e-6, 20), poly);
        double integral = ic.integrate(1.0, 5.0);
        System.out.println("Tích phân từ 1.0 đến 5.0: " + integral);
    }

    public void testListPolynomial() {
        Random random = new Random();
        int size = random.nextInt(5) + 1;
        MyListPolynomial poly = new MyListPolynomial();
        for (int i = 0; i < size; i++) {
            poly.append(random.nextDouble() * 10);
        }
        System.out.println("Đa thức gốc (ListPolynomial): " + poly);
        poly.append(1.23);
        System.out.println("Sau khi thêm 1.23: " + poly);
        poly.add(2.34, 1);
        System.out.println("Sau khi cộng 2.34 vào hệ số tại vị trí 1: " + poly);
        poly.set(5.67, 2);
        System.out.println("Sau khi đặt hệ số 5.67 tại vị trí 2: " + poly);
        MyListPolynomial p2 = new MyListPolynomial();
        size = random.nextInt(5) + 1;
        for (int i = 0; i < size; i++) {
            p2.append(random.nextDouble() * 5);
        }
        System.out.println("Đa thức thứ hai (ListPolynomial): " + p2);
        System.out.println("Tổng: " + poly.plus(p2));
        System.out.println("Hiệu: " + poly.minus(p2));
        System.out.println("Tích: " + poly.multiply(p2));
        double x = random.nextDouble() * 5;
        System.out.println("Giá trị tại x = " + x + ": " + poly.evaluate(x));
        IntegrationCalculator ic = new IntegrationCalculator(new SimpsonRule(1e-6, 20), poly);
        double integral = ic.integrate(2.0, 6.0);
        System.out.println("Tích phân từ 2.0 đến 6.0: " + integral);
    }
}
