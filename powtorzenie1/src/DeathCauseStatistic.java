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
}
