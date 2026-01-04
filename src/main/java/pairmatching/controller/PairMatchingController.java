package pairmatching.controller;

import pairmatching.model.Feature;
import pairmatching.model.MatchingMission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

/**
 * 프로그램의 전체 흐름 조율을 담당하는 클래스
 */
public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Feature feature = retry(this::selectFeature);
        MatchingMission matchingMission = retry(this::findCourseLevelMissionForMatching);
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Feature selectFeature() {
        outputView.printFeaturePrompt();
        String input = inputView.readFeature();
        return Feature.from(input);
    }

    private MatchingMission findCourseLevelMissionForMatching() {
        outputView.printCourseLevelMissionPrompt();
        List<String> input = inputView.readCourseLevelMission();
        return MatchingMission.from(input);
    }
}
