import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlantUMLRunner {
    public static String path;

    public static void setPath(String path) {
        PlantUMLRunner.path = path;
    }

    public static void generateScheme(String data, String pathToResultDir, String resultFileName) {
        File resultDir = new File(pathToResultDir);
        resultDir.mkdir();
//        File resultFile = new File(pathToResultDir + resultFileName + ".puml");
        try {
            FileWriter fileWriter = new FileWriter(pathToResultDir + "/" + resultFileName + ".puml");
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
