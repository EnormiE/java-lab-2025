import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular {
    private Map<String, String> codeDescDict = new HashMap<>();

    public ICDCodeTabularOptimizedForTime(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = "";
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if(++i < 88) {
                    continue;
                }
                if (!line.trim().matches("^[A-Z][0-9][0-9][^-]*")) { //trim kasuje niepotrzebne spacje, taby itp.
                    continue;          //regex ignoruje też myślnik, żeby spis rozdziałów ominąć
                }
                String[] segments = line.trim().split(" ", 2);
//                System.out.println(segments[1]); // desc
//                System.out.println(segments[0]); // code
                String code = segments[0];
                String description = segments[1];
//                codeDescDict[code] = description;
                codeDescDict.put(code, description);
            }
            reader.close();
        } catch (RuntimeException | IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public String getDescription(String icd10code) {
        if (!codeDescDict.containsKey(icd10code)) {
            throw new IndexOutOfBoundsException("Nie ma takeigo kodu w pliku :<");
        }
        return codeDescDict.get(icd10code);
    }
}
