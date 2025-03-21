import java.util.Arrays;
import java.util.Locale;

public class Polygon extends Shape {
    private Point[] points;

    // głęboka kopia punktów
    public Polygon(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]);
        }
    }

    // ze stylem
    public Polygon(Point[] points, Style style) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]);
        }
        super.style = style;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public String toSvg()
    {
        String pointsString = "";
        for(Point point : points) {
            pointsString += point.getX() + "," + point.getY() + " ";
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" style=\"%s\" />", pointsString, super.style.toSvg());
    }

    public BoundingBox boundingBox() {
        double xMin = this.points[0].getX();
        double xMax = this.points[0].getX();
        double yMin = this.points[0].getY();
        double yMax = this.points[0].getY();

        for (int i = 1; i < points.length; i++) {
            xMin = Math.min(xMin, points[i].getX());
            xMax = Math.max(xMax, points[i].getX());
            yMin = Math.min(yMin, points[i].getY());
            yMax = Math.max(yMax, points[i].getY());
        }
        return new BoundingBox(xMin, yMin, xMax - xMin, yMax - yMin);
    }

    public static Polygon square(Segment diagonal, Style style) {
        Point[] points = new Point[4];
        Segment perpendicular = diagonal.perpendicular(diagonal.length());

        double midX = (diagonal.getStart().getX() + diagonal.getEnd().getX()) / 2;
        double midY = (diagonal.getStart().getY() + diagonal.getEnd().getY()) / 2;

// Pierwsze dwa punkty to początek i koniec przekątnej
        points[0] = diagonal.getStart();
        points[1] = diagonal.getEnd();
// Tworzymy pozostałe dwa punkty za pomocą segmentu prostopadłego do przekątnej
        points[2] = new Point(midX + perpendicular.getStart().getX(), midY + perpendicular.getStart().getY());
        points[3] = new Point(midX + perpendicular.getEnd().getX(), midY + perpendicular.getEnd().getY());
        return new Polygon(points, style);
    }
}