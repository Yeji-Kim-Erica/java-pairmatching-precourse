package pairmatching.model;

public class MatchResult {
    private final MatchingMission matchingMission;
    private final Pairs pairs;

    public MatchResult(MatchingMission matchingMission, Pairs pairs) {
        this.matchingMission = matchingMission;
        this.pairs = pairs;
    }

    public Pairs getPairs() {
        return pairs;
    }

    public boolean equals(MatchingMission matchingMission) {
        return this.matchingMission.equals(matchingMission);
    }
}
