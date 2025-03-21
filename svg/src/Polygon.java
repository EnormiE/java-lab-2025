import java.util.Arrays;
import java.util.Locale;

public class Polygon extends Shape {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

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
        // Środek przekątnej
        double midX = (diagonal.getStart().getX() + diagonal.getEnd().getX()) / 2;
        double midY = (diagonal.getStart().getY() + diagonal.getEnd().getY()) / 2;

        // Wektor przekątnej
        double dx = diagonal.getEnd().getX() - diagonal.getStart().getX();
        double dy = diagonal.getEnd().getY() - diagonal.getStart().getY();

        // Długość boku kwadratu (przekątna / sqrt(2))
        double side = Math.sqrt(dx * dx + dy * dy) / Math.sqrt(2);

        // Jednostkowy wektor prostopadły do przekątnej
        double perpX = -dy / Math.sqrt(dx * dx + dy * dy);
        double perpY = dx / Math.sqrt(dx * dx + dy * dy);

        // Wyznaczanie czterech punktów kwadratu
        Point p1 = new Point(diagonal.getStart().getX(), diagonal.getStart().getY());
        Point p2 = new Point(diagonal.getEnd().getX(), diagonal.getEnd().getY());
        Point p3 = new Point(midX + perpX * side / 2, midY + perpY * side / 2);
        Point p4 = new Point(midX - perpX * side / 2, midY - perpY * side / 2);

        // Zwracamy nowy obiekt Polygon
        return new Polygon(new Point[]{p1, p3, p2, p4}, style);
    }

}