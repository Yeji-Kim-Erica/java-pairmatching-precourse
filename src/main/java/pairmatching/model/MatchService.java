package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MatchService {
    private final CrewRepository crewRepository;
    private final MatchRepository matchRepository;

    public MatchService(CrewRepository crewRepository, MatchRepository matchRepository) {
        this.crewRepository = crewRepository;
        this.matchRepository = matchRepository;
    }

    public void match(MatchingMission matchingMission) {
        Pairs pairs = matchPairs(matchingMission.getCourse());
        MatchResult matchResult = new MatchResult(matchingMission, pairs);
        matchRepository.save(matchResult);
    }

    public MatchResult getMatchResult(MatchingMission matchingMission) {
        return matchRepository.get(matchingMission);
    }

    private Pairs matchPairs(Course course) {
        List<String> crews = crewRepository.getNames(course);
        List<String> shuffledCrews = Randoms.shuffle(crews);
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < shuffledCrews.size(); i += 2) {
            Crew crew1 = new Crew(course, shuffledCrews.get(i));
            Crew crew2 = new Crew(course, shuffledCrews.get(i + 1));
            Pair pair = Pair.of(crew1, crew2);
            pairs.add(pair);
        }
        return new Pairs(pairs);
    }
}
