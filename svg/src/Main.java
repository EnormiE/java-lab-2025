public class Main {
    public static void main(String[] args) {
//        polygons();
        scene();
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

    public static void scene() {
        Polygon polygon1 = new Polygon(new Point[]{new Point(1.0, 10.0)});
        Polygon polygon2 = new Polygon(new Point[]{new Point(2.0, 20.0)});
        Polygon polygon3 = new Polygon(new Point[]{new Point(3.0, 30.5)});
        Polygon polygon4 = new Polygon(new Point[]{new Point(4.0, 40.5)});

        SvgScene scene = new SvgScene();
        scene.addPolygon(polygon1);
        System.out.println(scene);

        scene.addPolygon(polygon2);
        scene.addPolygon(polygon3);
        System.out.println(scene);

        scene.addPolygon(polygon4);
        System.out.println(scene);
    }
}
