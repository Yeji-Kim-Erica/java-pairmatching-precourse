package pairmatching.controller;

import pairmatching.model.*;
import pairmatching.util.FileParser;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.File;
import java.util.ArrayList;
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
        Crews backendCrews = getCrews(Course.BACKEND, "backend-crew.md");
        Crews frontendCrews = getCrews(Course.FRONTEND, "frontend-crew.md");

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

    private Crews getCrews(Course course, String fileName) {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/main/resources/" + fileName);

        return new Crews(course, FileParser.getInfo(file));
    }
}
