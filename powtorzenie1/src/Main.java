public class Main {
    public static void main(String[] args) {
        DeathCauseStatistic d1 =  DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");

        System.out.println(d1.ageToBrackets(8993));
    }
}