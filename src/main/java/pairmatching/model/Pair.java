package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pair {
    private final Crews crews;

    private Pair(Crews crews) {
        this.crews = crews;
    }

    public static Pair of(Crew crew1, Crew crew2) {
        Crews crews = new Crews(new ArrayList<>(Arrays.asList(crew1, crew2)));
        return new Pair(crews);
    }

    public Crews getCrews() {
        return crews;
    }

    public boolean equals(Pair pair) {
        boolean flag = true;
        for (Crew crew : crews.getCrews()) {
            if (!pair.contains(crew)) {
                flag = false;
            }
        }
        return flag;
    }

    private boolean contains(Crew crew1) {
        for (Crew crew2 : crews.getCrews()) {
            if (crew1.equals(crew2)) {
                return true;
            }
        }
        return false;
    }
}
