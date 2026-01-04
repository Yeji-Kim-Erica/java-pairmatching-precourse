package pairmatching.view;

import pairmatching.constant.Feature;

import static java.lang.System.out;

/**
 * 프로그램의 모든 출력을 담당하는 클래스
 */

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printBlankLine() {
        out.println();
    }

    public void printErrorMessage(IllegalArgumentException e) {
        out.println(ERROR_PREFIX + e.getMessage());
    }

    public void printFeaturePrompt() {
        out.println("기능을 선택하세요.");
        for (Feature feature : Feature.values()) {
            out.printf("%s. %s\n", feature.getOption(), feature.getName());
        }
    };
}
