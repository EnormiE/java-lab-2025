import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Shape[] shapes = new Shape[3];
    private int index = 0;
//    private BoundingBox boundingBox;

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

    public BoundingBox boundingBox() {
        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE, maxY = -Double.MAX_VALUE;

        for (Shape shape : this.shapes) {
            if (shape instanceof Polygon poly) {
                for (Point p : poly.getPoints()) {
                    minX = Math.min(minX, p.getX());
                    minY = Math.min(minY, p.getY());
                    maxX = Math.max(maxX, p.getX());
                    maxY = Math.max(maxY, p.getY());
                }
            }
        }

        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }

    public void save(String filePath) {
        BoundingBox box = this.boundingBox();

        if (box == null) {
            System.out.println("No polygons to save.");
            return;
        }

//        double offsetX = box.x();
//        double offsetY = box.y();
        double width = box.width();
        double height = box.height();

        StringBuilder svgContent = new StringBuilder();
        svgContent.append(String.format(
                "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%.2f\" height=\"%.2f\" viewBox=\"0 0 %.2f %.2f\">\n",
                width, height, width, height
        ));

        for (Shape shape : this.shapes) {
            if (shape == null) continue;
            svgContent.append(shape.toSvg()).append("\n");
        }

        svgContent.append("</svg>");

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(svgContent.toString());
            System.out.println("SVG file saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving SVG file: " + e.getMessage());
        }
    }

}