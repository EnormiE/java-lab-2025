import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SvgScene {
    private Shape[] shapes = new Shape[3];
    private int index = 0;

    public void addShape(Shape shape) {
        shapes[(index++) % 3] = shape;
    }

    public String toSvg()
    {
        String result = "<svg xmlns=\"http://www.w3.org/2000/svg\">";
        for(var shape : shapes) // var == automatyczny typ zmiennej
        {
            result += "\n\t" + shape.toSvg();
        }
        result += "\n</svg>";
        return result;
    }

    @Override
    public String toString() {
        return "SvgScene{" +
                "index=" + index +
                ", shapes=" + Arrays.toString(shapes) +
                '}';
    }

    public void save(String path) throws FileNotFoundException {
        // Coś z bounding boxem trzeba zrobić ale nie wiem do końca co i gdzie
        PrintWriter save = new PrintWriter(path);
        save.println(toSvg());
        save.close();
    }
}