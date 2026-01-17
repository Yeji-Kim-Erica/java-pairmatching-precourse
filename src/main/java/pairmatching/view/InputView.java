package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.error.ErrorMessage;
import pairmatching.util.InputParser;

import java.util.List;

/**
 * 프로그램의 모든 입력을 담당하는 클래스
 */
public class InputView {
    public String readFeature() {
        String input = Console.readLine();
        return InputParser.refineInput(input, ErrorMessage.NULL_OR_BLANK.getMessage());
    }

    public List<String> readCourseLevelMission() {
        String input = Console.readLine();
        String refinedInput = InputParser.refineInput(input, ErrorMessage.NULL_OR_BLANK.getMessage());
        return InputParser.parseToStrings(refinedInput, ErrorMessage.INVALID_FORMAT.getMessage());
    }
}
