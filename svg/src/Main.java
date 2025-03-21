import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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

    public static void scene() throws FileNotFoundException {

        Style style1 = new Style("yellow", "yellow", 3.0);

        Polygon polygon1 = new Polygon(new Point[]{
                new Point(15.0, 6.5),
                new Point(40.0, 1.5),
                new Point(80.0, 44.5)
        });
        Polygon polygon2 = new Polygon(new Point[]{
                new Point(116.0, 53.5),
                new Point(86.0, 33.5),
                new Point(20.0, 118)
        }
        );
        Polygon polygon3 = new Polygon(new Point[]{
                new Point(88.0, 8.5),
                new Point(10, 20),
                new Point(25, 45)
        },
                style1
        );

        SvgScene scene = new SvgScene();
        scene.addShape(polygon1);
        scene.addShape(polygon2);
        scene.addShape(polygon3);
        System.out.println(scene);
        System.out.println("\n" + scene.toSvg());

        System.out.println("\n" + polygon1.boundingBox());

//        scene.save("C:\\Users\\vebar\\Documents\\GitHub\\java-lab-2025\\file.svg");

        // square
        Point p = new Point(4.5, 2.0);
        Point p2 = p.translated(2.0, 1.0);
        Segment s1 = new Segment(p, p2);
        System.out.println("\n" + Polygon.square(s1, style1).toSvg() );
        scene.addShape(Polygon.square(s1, style1));

        // elipse
        Point center = new Point(30.0, 75.0);
        Style style2 = new Style("blue", "red", 3.0);
        Ellipse ellipse1 = new Ellipse(style2, center, 15.0, 10.0);
        System.out.println("\n" + ellipse1.toSvg());
        scene.addShape(ellipse1);
        scene.save("C:\\Users\\vebar\\Documents\\GitHub\\java-lab-2025\\file.svg");

    }
}
