package hus.oop.statistics;

public class Statistics {
    private MyList data;

    public Statistics(MyList data) {
        this.data = data;
    }

    public double max() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator it = data.iterator(0);
        double max = it.next().doubleValue();
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public double min() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator it = data.iterator(0);
        double min = it.next().doubleValue();
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public double mean() {
        int n = data.size();
        if (n == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator it = data.iterator(0);
        double sum = 0;
        while (it.hasNext()) {
            sum += it.next().doubleValue();
        }
        return sum / n;
    }

    public double variance() {
        int n = data.size();
        if (n < 2) {
            throw new IllegalStateException("Variance requires at least two data points");
        }
        double mean = mean();
        MyIterator it = data.iterator(0);
        double sumSq = 0;
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            sumSq += (v - mean) * (v - mean);
        }
        return sumSq / (n - 1);
    }

    public int search(double value) {
        return data.binarySearch(value);
    }

    public double[] rank() {
        int n = data.size();
        double[] values = new double[n];
        MyIterator it = data.iterator(0);
        for (int i = 0; i < n; i++) {
            values[i] = it.next().doubleValue();
        }
        double[] ranks = new double[n];
        for (int i = 0; i < n; i++) {
            int countLess = 0;
            for (int j = 0; j < n; j++) {
                if (values[j] < values[i]) {
                    countLess++;
                }
            }
            ranks[i] = countLess + 1;
        }
        return ranks;
    }
}
