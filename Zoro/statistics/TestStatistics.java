package hus.oop.statistics;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        TestStatistics tester = new TestStatistics(null);
        tester.testMyArrayList();
        tester.testMyLinkedList();
    }

    public void testMyArrayList() {
        int length = (int) (Math.random() * (50 - 30 + 1)) + 30;
        MyList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double v = 1 + Math.random() * (20 - 1);
            list.add(v);
        }
        statistics = new Statistics(list);
        System.out.println("Dữ liệu MyArrayList: " + list);
        MyList sortedList = list.sortIncreasing();
        System.out.println("Dữ liệu sau khi sắp xếp: " + sortedList);
        System.out.println("Giá trị lớn nhất: " + statistics.max());
        System.out.println("Giá trị nhỏ nhất: " + statistics.min());
        System.out.println("Trung bình (mean): " + statistics.mean());
        System.out.println("Phương sai (variance): " + statistics.variance());
        double[] ranks = statistics.rank();
        System.out.print("Thứ hạng (rank) của các phần tử: ");
        for (double r : ranks) {
            System.out.print(r + " ");
        }
        System.out.println();
        MyIterator it = list.iterator(0);
        double searchVal = it.next().doubleValue();
        System.out.println("Tìm giá trị tồn tại " + searchVal + ": chỉ số = " + statistics.search(searchVal));
        System.out.println("Tìm giá trị không tồn tại -1: chỉ số = " + statistics.search(-1));
    }

    public void testMyLinkedList() {
        int length = (int) (Math.random() * (50 - 30 + 1)) + 30;
        MyList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double v = 1 + Math.random() * (20 - 1);
            list.add(v);
        }
        statistics = new Statistics(list);
        System.out.println("Dữ liệu MyLinkedList: " + list);
        MyList sortedList = list.sortIncreasing();
        System.out.println("Dữ liệu sau khi sắp xếp: " + sortedList);
        System.out.println("Giá trị lớn nhất: " + statistics.max());
        System.out.println("Giá trị nhỏ nhất: " + statistics.min());
        System.out.println("Trung bình (mean): " + statistics.mean());
        System.out.println("Phương sai (variance): " + statistics.variance());
        double[] ranks = statistics.rank();
        System.out.print("Thứ hạng (rank) của các phần tử: ");
        for (double r : ranks) {
            System.out.print(r + " ");
        }
        System.out.println();
        MyIterator it = list.iterator(0);
        double searchVal = it.next().doubleValue();
        System.out.println("Tìm giá trị tồn tại " + searchVal + ": chỉ số = " + statistics.search(searchVal));
        System.out.println("Tìm giá trị không tồn tại -1: chỉ số = " + statistics.search(-1));
    }
}
