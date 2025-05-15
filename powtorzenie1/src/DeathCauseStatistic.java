import java.util.Arrays;

public class DeathCauseStatistic {
    private String icd10code;
    private int[] deathsByAgeGroup;

    public DeathCauseStatistic(String icd10code, int[] deathsByAgeGroup) {
        this.icd10code = icd10code;
        this.deathsByAgeGroup = deathsByAgeGroup;
    }

    public static DeathCauseStatistic fromCsvLine(String line) {
        String[] segments = line.trim().split(",");
//        System.out.println(segments[0]);
        String code = segments[0];
        int[] deaths = new int[20];
        for (int i = 2; i < segments.length; ++i) {
            if (!segments[i].equals("-")) {
                deaths[i - 2] = Integer.parseInt(segments[i]);
            }
            else {
                deaths[i - 2] =  0;
            }
        }
//        System.out.println(Arrays.toString(deaths));
        return new DeathCauseStatistic(code, deaths);
    }

    public String getIcd10code() {
        return icd10code;
    }

    public class AgeBracketDeaths {
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }

        @Override
        public String toString() {
            return "AgeBracketDeaths{" +
                    "young=" + young +
                    ", old=" + old +
                    ", deathCount=" + deathCount +
                    '}';
        }
    }

    public AgeBracketDeaths ageToBrackets(int age) {
        int[] young = {0, 5, 10, 15, 20 ,25, 30, 35, 40 , 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95};
        int[] old = {4, 9, 14, 19, 24 ,29, 34, 39, 44 , 49, 54, 59, 64, 69, 74, 79, 84, 89, 94, 999};
        int i = 0;
        for (int number : old) {
            if (age <= number) {
                return new AgeBracketDeaths(young[i], old[i], deathsByAgeGroup[i]);
            }
            else {
                ++i;
            }
        }
        return null; // gdy ktoś poda wiek > 999
    }
}
