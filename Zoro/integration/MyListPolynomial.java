package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    public MyListPolynomial() {
        this.coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) {
            return 0.0;
        }
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        int n = coefficients.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        trimTrailingZeros();
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        ensureSize(index + 1);
        coefficients.set(index, coefficients.get(index) + coefficient);
        trimTrailingZeros();
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        ensureSize(index + 1);
        coefficients.set(index, coefficient);
        trimTrailingZeros();
        return this;
    }

    @Override
    public int degree() {
        return coefficients.isEmpty() ? 0 : coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            result.append(coefficients.get(i) * i);
        }
        return result;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        int maxDeg = Math.max(this.degree(), right.degree());
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= maxDeg; i++) {
            result.append(this.coefficient(i) + right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        int maxDeg = Math.max(this.degree(), right.degree());
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= maxDeg; i++) {
            result.append(this.coefficient(i) - right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        int newDeg = this.degree() + right.degree();
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= newDeg; i++) {
            result.append(0.0);
        }
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                result.add(this.coefficient(i) * right.coefficient(j), i + j);
            }
        }
        return result;
    }

    private void ensureSize(int size) {
        while (coefficients.size() < size) {
            coefficients.add(0.0);
        }
    }

    private void trimTrailingZeros() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0.0) {
                break;
            }
            coefficients.remove(i);
        }
    }
}
