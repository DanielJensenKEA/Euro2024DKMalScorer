import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<MatchResult> matchResults;
    private HashMap<String, Integer> goalScorersTotal;

    public Statistics(String fileName) throws FileNotFoundException {
        //TODO: Instantiere MRFR for at læse en fil
        //TODO: Implementere fileName, der sendes som argument til MRFR.
        matchResults = new ArrayList<>();
        MatchResultFileReader mrfr = new MatchResultFileReader();
        var loadedList = mrfr.readFile();
        matchResults.addAll(loadedList);
    }
    public Set<String> getGoalScorers() {
        //TODO:
        Set<String> goalScorerNames = new HashSet<>();

        for (MatchResult mr : matchResults) {
            var goalScorersToAdd = mr.getGoalScorers();
            goalScorerNames.addAll(goalScorersToAdd);
        }
        return goalScorerNames;
    }
    public Map<String, Integer> getGoalScorersWithTotal() {
        //TODO:
        goalScorersTotal = new HashMap<>();

        for (MatchResult mr : matchResults) {
            List<String> goalScorers = mr.getGoalScorers();

            for (String scorer : goalScorers) {
                goalScorersTotal.merge(scorer, 1, Integer::sum);
            }
        }
        return goalScorersTotal;
    }

    public int getNumberOfGoals(String goalScorer) {
        //TODO:
//        var numberOfGoals = goalScorersTotal.get(goalScorer);
//        return numberOfGoals;
        return goalScorersTotal.get(goalScorer);
    }
}
