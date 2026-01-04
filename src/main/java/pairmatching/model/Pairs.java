package pairmatching.model;

import java.util.Collections;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }

    public boolean contains(Pair pair1) {
        for (Pair pair2 : pairs) {
            if (pair1.equals(pair2)) {
                return true;
            }
        }
        return false;
    }
}
