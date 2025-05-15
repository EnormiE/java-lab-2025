import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeathCauseStatisticList {
    public List<DeathCauseStatistic> list = new ArrayList<DeathCauseStatistic>();

    public void repopulate(String path) {
        list.clear();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = "";
            // skipujemy 2 pierwsze linijki
            reader.readLine();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                DeathCauseStatistic element = DeathCauseStatistic.fromCsvLine(line);
                list.add(element);
            }
            reader.close();
        } catch (RuntimeException | IOException e) {
            System.err.println(e);
            }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
        if (n > list.size()) {
            System.err.println("n większe niż liczba chorób");
            return null;
        }
        List<DeathCauseStatistic> tmpList = new ArrayList<DeathCauseStatistic>();
//        private Comparator cmp() {
//
//        }
        for (DeathCauseStatistic element : list) {
            if (element.ageToBrackets(age).deathCount > 0) {
                tmpList.add(element);
            }
        }
        boolean changed = false;
        while (true) {
            changed = false;
            for (int i = 0; i < tmpList.size(); ++i) {
                if (i + 1 < tmpList.size()) {
                    if (tmpList.get(i).ageToBrackets(age).deathCount > tmpList.get(i + 1).ageToBrackets(age).deathCount) {
                        DeathCauseStatistic tmpElement = tmpList.get(i + 1);
                        tmpList.set(i + 1, tmpList.get(i));
                        tmpList.set(i, tmpElement);
                        changed = true;
                    }
                }
            }
            if (!changed) {
                break;
            }
        }
        return tmpList.reversed().subList(0, n);
    }
}
