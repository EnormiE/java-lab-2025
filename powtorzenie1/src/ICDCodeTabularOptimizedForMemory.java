import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular {
    String path;
    public ICDCodeTabularOptimizedForMemory(String path) {
        this.path = path;
    }

    @Override
    public String getDescription(String icd10code) {
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
//                codeDescDict.put(code, description);
                if (icd10code.equals(code)) {
                    reader.close();
                    return description;
                }
            }
        } catch (RuntimeException | IOException e) {
            System.err.println(e);
        }
        throw new IndexOutOfBoundsException("Nie ma takeigo kodu w pliku :<");
    }
}
