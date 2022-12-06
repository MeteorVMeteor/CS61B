package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        }
        T res = get(0);
        for (int i = 1; i < size(); i++) {
            if (comparator.compare(res, get(i)) < 0) {
                res = get(i);
            }
        }
        return res;
    }

    public T max(Comparator<T> c) {
        Comparator<T> tmp = comparator;
        comparator = c;
        T res = max();
        comparator = tmp;
        return res;
    }
}
