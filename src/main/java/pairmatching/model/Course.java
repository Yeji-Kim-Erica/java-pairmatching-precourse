package pairmatching.model;

import pairmatching.error.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course from(String input) {
        for (Course course : Course.values()) {
            if (course.name.equals(input)) {
                return course;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.COURSE_UNAVAILABLE.getMessage());
    }
}
