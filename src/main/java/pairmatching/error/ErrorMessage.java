package pairmatching.error;

/**
 * 오류 메시지를 정의한 enum 클래스
 */
public enum ErrorMessage {
    NULL_OR_BLANK("입력값은 공백이거나 비어 있을 수 없습니다."),
    FEATURE_UNAVAILABLE("존재하지 않는 기능입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
