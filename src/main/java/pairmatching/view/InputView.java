package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.error.ErrorMessage;
import pairmatching.util.InputParser;

/**
 * 프로그램의 모든 입력을 담당하는 클래스
 */
public class InputView {
    public String readFeature() {
        String input = Console.readLine();
        return InputParser.refineInput(input, ErrorMessage.NULL_OR_BLANK.getMessage());
    }
}
