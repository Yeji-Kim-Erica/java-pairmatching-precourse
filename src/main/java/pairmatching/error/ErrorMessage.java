package pairmatching.error;

/**
 * 오류 메시지를 정의한 enum 클래스
 */
public enum ErrorMessage {
    NULL_OR_BLANK("입력값은 공백이거나 비어 있을 수 없습니다."),
    INVALID_FORMAT("입력 형식이 올바르지 않습니다."),
    FEATURE_UNAVAILABLE("존재하지 않는 기능입니다."),
    COURSE_UNAVAILABLE("존재하지 않는 과정입니다."),
    LEVEL_UNAVAILABLE("존재하지 않는 레벨입니다."),
    MISSION_UNAVAILABLE("존재하지 않는 미션입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
