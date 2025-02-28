public class Main {
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 4.5;
        p.y = 2.0;

        System.out.println(p);
        System.out.println(p);
        Point p2 = p.translated(2.0, 1.0);
        System.out.println(p + "\n" + p2);
        Segment s1 = new Segment();
//        s1 =
        System.out.println(s1);

    }
}
