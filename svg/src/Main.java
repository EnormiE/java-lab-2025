public class Main {
    public static void main(String[] args) {
//        Point p = new Point();
//        p.setX(4.5);
//        p.setY(2.0);
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
}
