package pairmatching.model;

import pairmatching.error.ErrorMessage;

public enum Feature {
    PAIR_MATCH("1", "페어 매칭"),
    PAIR_FETCH("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    EXIT("Q", "종료");

    private final String option;
    private final String name;

    Feature(String option, String name) {
        this.option = option;
        this.name = name;
    }

    public String getOption() {
        return option;
    }

    public String getName() {
        return name;
    }

    public static Feature from(String input) {
        for (Feature feature : Feature.values()) {
            if (feature.option.equals(input)) {
                return feature;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.FEATURE_UNAVAILABLE.getMessage());
    }
}
