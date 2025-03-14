import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SvgScene {
    private Polygon[] polygons = new Polygon[3];
    private int index = 0;

    public void addPolygon(Polygon polygon) {
        polygons[(index++) % 3] = polygon;
    }

    public String toSvg()
    {
        String result = "<svg xmlns=\"http://www.w3.org/2000/svg\">";
        for(var polygon : polygons) // var == automatyczny typ zmiennej
        {
            result += "\n\t" + polygon.toSvg();
        }
        result += "\n</svg>";
        return result;
    }

    @Override
    public String toString() {
        return "SvgScene{" +
                "index=" + index +
                ", polygons=" + Arrays.toString(polygons) +
                '}';
    }

    public void save(String path) throws FileNotFoundException {
        // Coś z bounding boxem trzeba zrobić ale nie wiem do końca co i gdzie
        PrintWriter save = new PrintWriter(path);
        save.println(toSvg());
        save.close();
    }
}