import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) {

        try {
            Statistics s = new Statistics("Euro2024QualifyingRound");
            String name = "Delaney";

            System.out.println("Hvem har scoret mål?:");
            System.out.println(s.getGoalScorers());

            System.out.println("Antal mål af gyldige spillere:");
            System.out.println(s.getGoalScorersWithTotal());
            if (!name.isEmpty()) {
                System.out.println("Antal mål for spilleren: "+"'"+name+"'"+".");
                System.out.println(s.getNumberOfGoals(name));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
