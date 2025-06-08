package hus.oop.matrix;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MySquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [10, 90]
     * @param size kích thước ma trận vuông
     */
    public MySquareMatrix(int size) {
        initRandom(size);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [10, 90]
     * @param size kích thước ma trận vuông
     */
    private void initRandom(int size) {
        data = new int[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = rand.nextInt(81) + 10; // giá trị ngẫu nhiên từ 10 đến 90
            }
        }
    }

    /**
     * Lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return mảng chứa đường chéo chính
     */
    public int[] principalDiagonal() {
        int n = data.length;
        int[] diag = new int[n];
        for (int i = 0; i < n; i++) {
            diag[i] = data[i][i];
        }
        return diag;
    }

    /**
     * Lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return mảng chứa đường chéo phụ
     */
    public int[] secondaryDiagonal() {
        int n = data.length;
        int[] diag = new int[n];
        for (int i = 0; i < n; i++) {
            diag[i] = data[i][n - 1 - i];
        }
        return diag;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return mảng chứa các số nguyên tố
     */
    public int[] primes() {
        List<Integer> list = new ArrayList<>();
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPrime(data[i][j])) {
                    list.add(data[i][j]);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // Kiểm tra số nguyên tố
    private boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    /**
     * Sắp xếp các phần tử của ma trận theo thứ tự giảm dần và tạo ma trận mới.
     * @return ma trận mới đã được sắp xếp giảm dần
     */
    public MySquareMatrix getSortedMatrix() {
        int n = data.length;
        int total = n * n;
        int[] flat = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flat[idx++] = data[i][j];
            }
        }
        Arrays.sort(flat);
        // Đảo để thành thứ tự giảm dần
        int[] desc = new int[total];
        for (int i = 0; i < total; i++) {
            desc[i] = flat[total - 1 - i];
        }
        int[][] sortedData = new int[n][n];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sortedData[i][j] = desc[idx++];
            }
        }
        // Tạo ma trận mới và gán dữ liệu đã sắp xếp
        MySquareMatrix m = new MySquareMatrix(n);
        m.data = sortedData;
        return m;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     */
    public int get(int row, int col) {
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col).
     */
    public void set(int row, int col, int value) {
        data[row][col] = value;
    }

    /**
     * Cộng ma trận hiện tại với ma trận khác.
     */
    public MySquareMatrix add(MySquareMatrix that) {
        int n = data.length;
        MySquareMatrix m = new MySquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m.data[i][j] = this.data[i][j] + that.data[i][j];
            }
        }
        return m;
    }

    /**
     * Trừ ma trận hiện tại với ma trận khác.
     */
    public MySquareMatrix minus(MySquareMatrix that) {
        int n = data.length;
        MySquareMatrix m = new MySquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m.data[i][j] = this.data[i][j] - that.data[i][j];
            }
        }
        return m;
    }

    /**
     * Nhân ma trận hiện tại với ma trận khác.
     */
    public MySquareMatrix multiply(MySquareMatrix that) {
        int n = data.length;
        MySquareMatrix m = new MySquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += this.data[i][k] * that.data[k][j];
                }
                m.data[i][j] = sum;
            }
        }
        return m;
    }

    /**
     * Nhân ma trận với một số vô hướng.
     */
    public MySquareMatrix scaled(int value) {
        int n = data.length;
        MySquareMatrix m = new MySquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m.data[i][j] = this.data[i][j] * value;
            }
        }
        return m;
    }

    /**
     * Ma trận chuyển vị.
     */
    public MySquareMatrix transpose() {
        int n = data.length;
        MySquareMatrix m = new MySquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m.data[i][j] = data[j][i];
            }
        }
        return m;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn dòng.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(data[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            if (i < n - 1) sb.append("\n");
        }
        return sb.toString();
    }
}
