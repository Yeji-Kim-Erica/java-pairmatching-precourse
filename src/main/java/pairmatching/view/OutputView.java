package pairmatching.view;

import pairmatching.model.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * 프로그램의 모든 출력을 담당하는 클래스
 */

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String OUTLINE = "#############################################";

    public void printBlankLine() {
        out.println();
    }

    public void printErrorMessage(IllegalArgumentException e) {
        out.println(ERROR_PREFIX + e.getMessage());
    }

    public void printFeaturePrompt() {
        out.println();
        out.println("기능을 선택하세요.");
        for (Feature feature : Feature.values()) {
            out.printf("%s. %s\n", feature.getOption(), feature.getName());
        }
    };

    public void printCourseLevelMissionPrompt() {
        out.println();
        out.println(OUTLINE);
        printCourses();
        printLevelsAndMissions();
        out.println(OUTLINE);
        out.println("과정, 레벨, 미션을 선택하세요.");
        out.println("ex) 백엔드, 레벨1, 자동차경주");
    };

    public void printMatchResult(MatchResult matchResult) {
        out.println();
        out.println("페어 매칭 결과입니다.");
        for (Pair pair : matchResult.getPairs().getPairs()) {
            Crews crews = pair.getCrews();
            out.println(String.join(" : ", crews.getNames()));
        }
    };

    private void printCourses() {
        List<String> courses = new ArrayList<>();
        for (Course course : Course.values()) {
            courses.add(course.getName());
        }
        out.printf("과정: %s\n", String.join(" | ", courses));
    }

    private void printLevelsAndMissions() {
        out.println("미션: ");
        for (Level level : Level.values()) {
            out.printf("  - %s: %s\n", level.getName(), String.join(" | ", level.getMissions()));
        }
    }
}
