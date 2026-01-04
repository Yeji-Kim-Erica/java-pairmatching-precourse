package pairmatching.model;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static Crew of(String course, String name) {
        return new Crew(Course.valueOf(course.toUpperCase()), name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public boolean isPartOf(Course course) {
        return this.course.equals(course);
    }

    public boolean equals(Crew crew) {
        return crew.course.equals(this.course) && crew.name.equals(this.name);
    }
}
