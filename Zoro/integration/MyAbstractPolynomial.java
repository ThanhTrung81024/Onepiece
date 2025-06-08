package hus.oop.integration;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    @Override
    public String toString() {
        double[] coeffs = coefficients();
        if (coeffs == null || coeffs.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < coeffs.length; i++) {
            double c = coeffs[i];
            if (i > 0) {
                sb.append(c >= 0 ? " + " : " - ").append(Math.abs(c));
            } else {
                sb.append(c);
            }
            if (i >= 1) {
                sb.append("x");
                if (i >= 2) {
                    sb.append("^").append(i);
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public double[] differentiate() {
        double[] coeffs = coefficients();
        if (coeffs == null || coeffs.length < 2) {
            return new double[]{0.0};
        }
        double[] deriv = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            deriv[i - 1] = coeffs[i] * i;
        }
        return deriv;
    }
}
