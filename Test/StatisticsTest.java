import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.*;

class StatisticsTest {
    private Statistics statistics;
    List<MatchResult> testMR = List.of(new MatchResult("Danmark-Kroatien", List.of("Delaney", "Højlund", "Poulsen")));


    @Test
    void getGoalScorers() throws FileNotFoundException {
        // Arrange
        Set<String> goalScorerNamesTest = new HashSet<>();
//        Collections.addAll(goalScorerNamesTest, "Delaney", "Højlund", "Poulsen");
        for (MatchResult mr : testMR) {
            var goalScorerNamesToGet = mr.getGoalScorers();
            goalScorerNamesTest.addAll(goalScorerNamesToGet);
        }
        //Act
        Set<String> expectedNames = Set.of("Delaney", "Højlund", "Poulsen");
        Set<String> actualNames = goalScorerNamesTest;

        //Assert
        Assertions.assertEquals(expectedNames, actualNames);
    }

    @Test
    void getGoalScorersWithTotal() {
        //Arrange
        HashMap<String, Integer> goalScorersTotalTestActual = new HashMap();

        HashMap<String, Integer> goalScorersTotalTestExpected = new HashMap<>();


        //Act
        for (MatchResult mr : testMR) {
            List<String > goalScorersTest = mr.getGoalScorers();

            for (String scorer : goalScorersTest) {
                goalScorersTotalTestActual.merge(scorer, 1, Integer::sum);
            }
        }

        goalScorersTotalTestExpected.put("Delaney", 1);
        goalScorersTotalTestExpected.put("Højlund", 1);
        goalScorersTotalTestExpected.put("Poulsen", 1);

        //Assert
        Assertions.assertEquals(goalScorersTotalTestActual,goalScorersTotalTestExpected);
    }

    @Test
    void getNumberOfGoals() {
        //Arrange
        HashMap<String, Integer> goalScorersTotalActual = new HashMap<>();
        HashMap<String, Integer> goalScorersTotalExpected = new HashMap<>();


        //Act
        for (MatchResult mr : testMR) {
            List<String> listTest1 = mr.getGoalScorers();

            for (String scorer : listTest1) {
                goalScorersTotalActual.merge(scorer, 1, Integer::sum);
            }
        }
        goalScorersTotalExpected.put("Delaney", 1);
        goalScorersTotalExpected.put("Højlund", 1);
        goalScorersTotalExpected.put("Poulsen", 1);

        int delaneyGoalExpected = goalScorersTotalExpected.get("Delaney");
        int delaneyGoalActual = goalScorersTotalActual.get("Delaney");
        //Assert
        Assertions.assertEquals(delaneyGoalExpected, delaneyGoalActual);
    }
}