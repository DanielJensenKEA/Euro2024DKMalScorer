import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MatchResultFileReader {
    //TODO:
    private List<MatchResult> loadedList;
    Scanner sc;
    File file = new File("Euro2024QualifyingRound.csv");
    MatchResult mr;

    public MatchResultFileReader() throws FileNotFoundException {
        //TODO: Load File? NVM, dette er konstruktør
//        file = new File(fileName+".csv");
        sc = new Scanner(file);
//        readFile();
    }

    public List <MatchResult> readFile() {
        loadedList = new ArrayList<>();

        while(sc.hasNext()) {
            String line = sc.nextLine();
            if (!line.isEmpty()) {
                String[] attributes = line.split(";");

                String teams = attributes[0];

                List<String> goalScorers = new ArrayList<>();
                if (attributes.length > 1) {
                    String[] scorerArray = attributes[1].split(",");
                    for (String scorer : scorerArray) {
                        goalScorers.add(scorer.trim());
                    }
                }
                mr = new MatchResult(teams, goalScorers);
                loadedList.add(mr);
            }
//            MatchResult mr;
//            String teams = sc.nextLine();
//
//            String[] attributes = teams.split(";");
//            String[] goalScorers = teams.split(")
//
//            if (!line.isEmpty()) {
//
//                mr = new MatchResult(attributes[0], )
//            }
        }
        //TODO: Mens der er ulæste linjer i filen:
        //Indlæs en linje i filen
        //parse dataen og opret MatchResult objekt
        //Hvis der ikke er nogle målscorere
        //skal listen være tom ellers skal listen indeholde navnet for hvert mål scoret
        return loadedList;
    }
}
