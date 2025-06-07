package hus.oop.sortstrategy;

public class SortStrategy {
    private static SortStrategy instance;

    private ISort sortee;

    private SortStrategy() {

    }

    public static SortStrategy getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public void setSortee(ISort sortee) {
        /* TODO */
        this.sortee = sortee;
    }

    public int sort(int[] data) {
        /* TODO */
        if (sortee == null) {
            throw new IllegalStateException("No sorting algorithm is set.");
        }
        return sortee.sort(data);
    }
}
