import java.util.List;

public class MatchResult {
    private String teams;
    private List<String> goalScorers;

    public MatchResult(String teams, List<String> goalScorers) {
        //TODO:
        this.teams = teams;
        this.goalScorers = goalScorers;
    }

    public List<String> getGoalScorers() {
        //TODO:
        return goalScorers;
    }

}
