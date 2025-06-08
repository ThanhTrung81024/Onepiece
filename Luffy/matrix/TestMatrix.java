package hus.oop.matrix;
import java.util.*;

public class TestMatrix {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */

        // Tạo kích thước ngẫu nhiên trong [5, 10]
        Random rand = new Random();
        int size = rand.nextInt(6) + 5; // 0-5 + 5 => 5-10

        // Khởi tạo 2 ma trận
        MySquareMatrix m1 = new MySquareMatrix(size);
        MySquareMatrix m2 = new MySquareMatrix(size);

        // In 2 ma trận ban đầu
        System.out.println("Matrix 1 (" + size + "x" + size + "):");
        System.out.println(m1);
        System.out.println();

        System.out.println("Matrix 2 (" + size + "x" + size + "):");
        System.out.println(m2);
        System.out.println();

        // In ma trận chuyển vị
        System.out.println("Transpose of Matrix 1:");
        System.out.println(m1.transpose());
        System.out.println();

        System.out.println("Transpose of Matrix 2:");
        System.out.println(m2.transpose());
        System.out.println();

        // In đường chéo chính và phụ
        System.out.println("Principal diagonal of Matrix 1: " + Arrays.toString(m1.principalDiagonal()));
        System.out.println("Secondary diagonal of Matrix 1: " + Arrays.toString(m1.secondaryDiagonal()));
        System.out.println();

        System.out.println("Principal diagonal of Matrix 2: " + Arrays.toString(m2.principalDiagonal()));
        System.out.println("Secondary diagonal of Matrix 2: " + Arrays.toString(m2.secondaryDiagonal()));
        System.out.println();

        // In phép cộng, trừ, nhân
        System.out.println("Sum (Matrix1 + Matrix2):");
        System.out.println(m1.add(m2));
        System.out.println();

        System.out.println("Difference (Matrix1 - Matrix2):");
        System.out.println(m1.minus(m2));
        System.out.println();

        System.out.println("Product (Matrix1 * Matrix2):");
        System.out.println(m1.multiply(m2));
        System.out.println();

        // In các số nguyên tố
        System.out.println("Primes in Matrix 1: " + Arrays.toString(m1.primes()));
        System.out.println("Primes in Matrix 2: " + Arrays.toString(m2.primes()));
    }
}
