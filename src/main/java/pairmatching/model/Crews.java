package pairmatching.model;

import pairmatching.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crews {
    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Crew crew : crews) {
            names.add(crew.getName());
        }
        return names;
    }

    public List<String> getNames(Course course) {
        List<String> names = new ArrayList<>();
        for (Crew crew : crews) {
            if (crew.isPartOf(course)) {
                names.add(crew.getName());
            }
        }
        return names;
    }

    public Crew getCrew(Course course, String name) {
        Crew tempCrew = new Crew(course, name);
        for (Crew crew : crews) {
            if (crew.equals(tempCrew)) {
                return crew;
            }
        }
        throw new IllegalStateException(ErrorMessage.INVALID_CREW.getMessage());
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }
}
