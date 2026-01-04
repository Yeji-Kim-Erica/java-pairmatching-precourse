package pairmatching.model;

import java.util.List;

public class Crews {
    private final Course course;
    private final List<String> names;

    public Crews(Course course, List<String> names) {
        this.course = course;
        this.names = names;
    }
}
