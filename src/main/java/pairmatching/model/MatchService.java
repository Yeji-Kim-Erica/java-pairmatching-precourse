package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        while (shuffledCrews.size() > 3) {
            addPairs(course, shuffledCrews, pairs);
        }
        addLastPairs(course, shuffledCrews, pairs);
        return new Pairs(pairs);
    }

    private void addPairs(Course course, List<String> shuffledCrews, List<Pair> pairs) {
        Crew crew1 = crewRepository.getCrew(course, shuffledCrews.remove(0));
        Crew crew2 = crewRepository.getCrew(course, shuffledCrews.remove(0));
        Pair pair = Pair.of(crew1, crew2);
        pairs.add(pair);
    }

    private void addLastPairs(Course course, List<String> shuffledCrews, List<Pair> pairs) {
        Crew[] crews = new Crew[shuffledCrews.size()];
        for (int i = 0; i < crews.length; i++) {
            Crew crew = crewRepository.getCrew(course, shuffledCrews.remove(0));
            crews[i] = crew;
        }
        Pair pair = Pair.of(crews);
        pairs.add(pair);
    }
}
