package hus.oop.statistics;

public abstract class MyAbstractList implements MyList {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MyIterator it = iterator(0);
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
