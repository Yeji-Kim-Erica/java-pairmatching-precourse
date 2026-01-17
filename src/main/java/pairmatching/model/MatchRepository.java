package pairmatching.model;

import pairmatching.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class MatchRepository {
    private final List<MatchResult> matchResults;

    public MatchRepository() {
        this.matchResults = new ArrayList<>();
    }

    public void save(MatchResult matchResult) {
        matchResults.add(matchResult);
    }

    public MatchResult get(MatchingMission matchingMission) {
        for (MatchResult matchResult : matchResults) {
            if (matchResult.equals(matchingMission)) {
                return matchResult;
            }
        }
        throw new IllegalStateException(ErrorMessage.MATCH_RESULT_UNAVAILABLE.getMessage());
    }
}
