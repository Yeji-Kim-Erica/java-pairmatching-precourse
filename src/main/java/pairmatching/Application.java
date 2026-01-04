package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.model.*;
import pairmatching.util.FileParser;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        CrewRepository crewRepository = new CrewRepository(getCrews());
        MatchRepository matchRepository = new MatchRepository();

        MatchService matchService = new MatchService(crewRepository, matchRepository);

        return new PairMatchingController(inputView, outputView, matchService);
    }

    private static Crews getCrews() {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/main/resources");
        List<Crew> crews = new ArrayList<>();
        for (File nameFile : Objects.requireNonNull(file.listFiles())) {
            String course = nameFile.getName().replace("-crew.md", "");
            for (String name : FileParser.getInfo(nameFile)) {
                crews.add(Crew.of(course, name));
            }
        }
        return new Crews(crews);
    }
}
