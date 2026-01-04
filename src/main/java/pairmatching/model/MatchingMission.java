package pairmatching.model;

import pairmatching.error.ErrorMessage;

import java.util.List;

public class MatchingMission {
    private final Course course;
    private final Level level;
    private final String mission;

    private MatchingMission(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static MatchingMission from(List<String> input) {
        validateFormat(input);
        Course course = Course.from(input.get(0));
        Level level = Level.from(input.get(1));
        String mission = input.get(2);
        validateMission(level, mission);
        return new MatchingMission(course, level, mission);
    }

    private static void validateFormat(List<String> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private static void validateMission(Level level, String mission) {
        if (level.contains(mission)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.MISSION_UNAVAILABLE.getMessage());
    }
}
