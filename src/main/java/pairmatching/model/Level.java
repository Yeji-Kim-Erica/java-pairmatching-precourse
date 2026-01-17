package pairmatching.model;

import pairmatching.error.ErrorMessage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", new ArrayList<>(Arrays.asList("자동차경주", "로또", "숫자야구게임"))),
    LEVEL2("레벨2", new ArrayList<>(Arrays.asList("장바구니", "결제", "지하철노선도"))),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", new ArrayList<>(Arrays.asList("성능개선", "배포"))),
    LEVEL5("레벨5", new ArrayList<>());

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return Collections.unmodifiableList(missions);
    }

    public static Level from(String input) {
        for (Level level : Level.values()) {
            if (level.name.equals(input)) {
                return level;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.LEVEL_UNAVAILABLE.getMessage());
    }

    public boolean contains(String mission) {
        return missions.contains(mission);
    }
}
