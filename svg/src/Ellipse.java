import java.util.Locale;

public class Ellipse extends Shape {
    private Point center;
    private double radiusX;
    private double radiusY;

    public Ellipse(Style style, Point center, double radiusX, double radiusY) {
        super(style);
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    String toSvg() {
        String svg = String.format(
                Locale.ENGLISH,
                "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" style=\"",
                center.getX(),
                center.getY(),
                radiusX,
                radiusY
        );

        return svg + style.toSvg() + "\" />";
    }
}
