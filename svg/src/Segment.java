public class Segment {
    public Point a;
    public Point b;
    public double length() {
        return Math.hypot((a.getX() - b.getX()), (a.getY() - b.getY()));
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
