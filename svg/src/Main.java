public class Main {
    public static void main(String[] args) {
        polygons();
    }

    public static void oldCode() {
        Point p = new Point(4.5, 2.0);

        Point p2 = p.translated(2.0, 1.0);

        Segment s1 = new Segment(p, p2);

        Point p3 = p2.translated(0.5, 2.0);

        Segment s2 = new Segment(p2, p3);

        System.out.println("p: "+ p + "\np2: " + p2 + "\np3: " + p3);
        Segment[] segments = {s1, s2};
        System.out.println(s1 + "\n" + s2);
        System.out.println("The longest segment:\n" + Segment.longest_segment(segments));

        Segment s3 = new Segment(new Point(0.0, 0.0), new Point(1.0, 1.0));
        System.out.println("\n" + s3);
    }

    public static void polygons() {
        Point[] points = {
                new Point(10.0, 50.0),
                new Point(50.0, 100.0),
                new Point(100.0, 150.0)
        };

        Polygon polygon = new Polygon(points);
        System.out.println(polygon);
        System.out.println(polygon.toSvg());
        points[0].setX(2.0); // test czy głęboka kopia działa
        System.out.println(polygon.toSvg());
    }
}
