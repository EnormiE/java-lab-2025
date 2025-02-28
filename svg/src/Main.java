public class Main {
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 4.5;
        p.y = 2.0;

        System.out.println(p);
        p.translate(2.0, 1.0);
        System.out.println(p);
        System.out.println("\nOriginal point: " + p + "\nTranslated point: " + p.translated(2.0, 1.0));
    }
}
