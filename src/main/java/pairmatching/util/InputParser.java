package pairmatching.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 입력을 변환, 검증하는 유틸리티 클래스
 */
public final class InputParser {
    private InputParser() {}

    public static String refineInput(String input, String errorMessage) {
        boolean isNullOrBlank = (input == null) || input.trim().isEmpty();
        if (isNullOrBlank) {
            throw new IllegalArgumentException(errorMessage);
        }
        return input.trim();
    }

    public static int parseToInt(String input, String errorMessage) {
        String refinedInput = refineInput(input, errorMessage);
        try {
            return Integer.parseInt(refinedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static List<String> parseToStrings(String input, String errorMessage) {
        List<String> result = new ArrayList<>();
        for (String str : input.split("\\s*,\\s*")){
            String refinedStr = refineInput(str, errorMessage);
            result.add(refinedStr);
        };
        return result;
    }
}
