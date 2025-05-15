public class Main {
    public static void main(String[] args) {
        DeathCauseStatistic d1 =  DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
//        System.out.println(d1.ageToBrackets(83));
        DeathCauseStatisticList l1 = new DeathCauseStatisticList();
        l1.repopulate("C:\\Users\\vebar\\Documents\\GitHub\\java-lab-2025\\powtorzenie1\\resources\\zgony.csv");
//        System.out.println(l1.list);
//        System.out.println(l1.list.get(0).getIcd10code());
//        System.out.println(l1.list.get(2620).getIcd10code());
//        System.out.println(l1.list.get(2620).ageToBrackets(3));
//        System.out.println(l1.mostDeadlyDiseases(3, 5));
        ICDCodeTabularOptimizedForTime t1 = new ICDCodeTabularOptimizedForTime("C:\\Users\\vebar\\Documents\\GitHub\\java-lab-2025\\powtorzenie1\\resources\\icd10.txt");
        ICDCodeTabularOptimizedForMemory t2 = new ICDCodeTabularOptimizedForMemory("C:\\Users\\vebar\\Documents\\GitHub\\java-lab-2025\\powtorzenie1\\resources\\icd10.txt");
        System.out.println(t1.getDescription("A52.8"));
        System.out.println(t2.getDescription("A52.8"));


    }
}