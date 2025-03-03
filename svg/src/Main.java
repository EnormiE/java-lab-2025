public class Main {
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 4.5;
        p.y = 2.0;

        Point p2 = p.translated(2.0, 1.0);

        Segment s1 = new Segment();
        s1.a = p;
        s1.b = p2;

        Point p3 = p2.translated(0.5, 2.0);

        Segment s2 = new Segment();
        s2.a = p2;
        s2.b = p3;
        System.out.println("p: "+ p + "\np2: " + p2 + "\np3: " + p3);
        Segment[] segments = {s1, s2};
//        System.out.println("\n" + segments[0].length() + " " + segments[1].length());
        System.out.println("The longest segment:\n" + Segment.longest_segment(segments).a + " - " + Segment.longest_segment(segments).b);
    }
}
