package hus.oop.integration;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    public MyArrayPolynomial() {
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            return 0.0;
        }
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficents, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        if (size >= coefficents.length) {
            allocateMore();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        while (index >= coefficents.length) {
            allocateMore();
        }
        coefficents[index] += coefficient;
        if (index >= size && coefficents[index] != 0.0) {
            size = index + 1;
        }
        if (index == size - 1 && coefficents[index] == 0.0) {
            while (size > 0 && coefficents[size - 1] == 0.0) {
                size--;
            }
        }
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        while (index >= coefficents.length) {
            allocateMore();
        }
        coefficents[index] = coefficient;
        if (index >= size && coefficient != 0.0) {
            size = index + 1;
        }
        if (index == size - 1 && coefficient == 0.0) {
            while (size > 0 && coefficents[size - 1] == 0.0) {
                size--;
            }
        }
        return this;
    }

    @Override
    public int degree() {
        return size > 0 ? size - 1 : 0;
    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = size - 1; i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 1; i < size; i++) {
            result.append(coefficents[i] * i);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        int maxDegree = Math.max(this.degree(), right.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            result.append(this.coefficient(i) + right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        int maxDegree = Math.max(this.degree(), right.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            result.append(this.coefficient(i) - right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        int newDegree = this.degree() + right.degree();
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= newDegree; i++) {
            result.append(0.0);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= right.degree(); j++) {
                result.add(this.coefficient(i) * right.coefficient(j), i + j);
            }
        }
        return result;
    }

    private void allocateMore() {
        double[] newArr = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newArr, 0, coefficents.length);
        coefficents = newArr;
    }
}
