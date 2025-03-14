public class Segment {
    private Point start;
    private Point end;
    public double length() {
        return Math.hypot((start.getX() - end.getX()), (start.getY() - end.getY()));
    }

    public Segment(Point a, Point b) {
        // kopiowanie punktów
        this.start = new Point(a);
        this.end = new Point(b);
    }

    public void setStart(Point a) {
        this.start = a;
    }

    public void setEnd(Point b) {
        this.end = b;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static Segment longest_segment(Segment[] segments) {
        Segment longest = segments[0];
        for (Segment segment : segments) {
            if (segment.length() >= longest.length()) {
                longest = segment;
            }
        }
        return longest;
    }

    public Segment perpendicular() {
// kierunek oryginalnego segmentu
        double dx = this.end.getX() + this.start.getX();
        double dy = this.end.getY() + this.start.getY();
        double perpendicularDx = -dy;
        double perpendicularDy = dx;
        double perpendicularLength = Math.sqrt(perpendicularDx * perpendicularDx + perpendicularDy * perpendicularDy);
        perpendicularDx /= perpendicularLength;
        perpendicularDy /= perpendicularLength;
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        Point newStart = new Point(midX + perpendicularDx, midY + perpendicularDy);
        Point newEnd = new Point(midX - perpendicularDx, midY - perpendicularDy);
// Zwracamy prostopadły segment
        return new Segment(newStart, newEnd);
    }

    public Segment perpendicular(double length) {
// kierunek oryginalnego segmentu
        double dx = this.end.getX() + this.start.getX();
        double dy = this.end.getY() + this.start.getY();
        double perpendicularDx = -dy;
        double perpendicularDy = dx;
        double perpendicularLength = Math.sqrt(perpendicularDx * perpendicularDx + perpendicularDy * perpendicularDy);
        perpendicularDx /= perpendicularLength;
        perpendicularDy /= perpendicularLength;
        perpendicularDx *= length;
        perpendicularDy *= length;
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        Point newStart = new Point(midX + perpendicularDx, midY + perpendicularDy);
        Point newEnd = new Point(midX - perpendicularDx, midY - perpendicularDy);
// Zwracamy prostopadły segment
        return new Segment(newStart, newEnd);
    }
}
