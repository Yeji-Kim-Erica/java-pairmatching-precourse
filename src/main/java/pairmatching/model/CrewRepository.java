package pairmatching.model;

import java.util.List;

public class CrewRepository {
    private final Crews crews;

    public CrewRepository(Crews crews) {
        this.crews = crews;
    }

    public List<String> getNames(Course course) {
        return crews.getNames(course);
    }

    public Crew getCrew(Course course, String name) {
        return crews.getCrew(course, name);
    }
}
