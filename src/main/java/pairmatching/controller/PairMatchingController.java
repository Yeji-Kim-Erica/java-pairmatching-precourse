package pairmatching.controller;

import pairmatching.model.*;
import pairmatching.util.FileParser;
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
    private final MatchService matchService;

    public PairMatchingController(InputView inputView, OutputView outputView, MatchService matchService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchService = matchService;
    }

    public void run() {
        Feature feature;
        MatchingMission matchingMission;

        while (true) {
            feature = retry(this::selectFeature);
            if (feature.equals(Feature.EXIT)) {
                return;
            }

            matchingMission = retry(this::findCourseLevelMissionForMatching);
            if (feature.equals(Feature.PAIR_MATCH)) {
                matchService.match(matchingMission);
                MatchResult matchResult = matchService.getMatchResult(matchingMission);
                outputView.printMatchResult(matchResult);
            }
        }
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
