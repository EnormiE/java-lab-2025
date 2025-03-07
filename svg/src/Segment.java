public class Segment {
    private Point a;
    private Point b;
    public double length() {
        return Math.hypot((a.getX() - b.getX()), (a.getY() - b.getY()));
    }

    public Segment(Point a, Point b) {
        // kopiowanie punktów
        this.a = new Point(a);
        this.b = new Point(b);
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "a=" + a +
                ", b=" + b +
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
}
