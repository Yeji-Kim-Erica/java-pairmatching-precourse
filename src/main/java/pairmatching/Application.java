package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

/**
 * 프로그램 진입점을 담당하는 클래스
 */
public class Application {
    public static void main(String[] args) {
        PairMatchingController controller = appConfig();
        controller.run();
    }

    private static PairMatchingController appConfig() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new PairMatchingController(inputView, outputView);
    }
}
